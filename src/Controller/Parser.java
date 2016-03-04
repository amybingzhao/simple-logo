package Controller;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import Model.*;

/**
 * This class is used to parse command strings into Command objects.
 *
 * @author amyzhao
 * @author blakekaplan
 */
public class Parser {

    private static final String CONSTANT = "Constant";
    private static final String VARIABLE = "Variable";
    private static final String COMMENT = "Comment";
    private static final String LIST_START = "ListStart";
    private static final String LIST_END = "ListEnd";
    private static final String TURTLE_COMMANDS = "TurtleCommands";
    private static final String COMMAND = "Command";
    private static final String MAKE_USER_INSTRUCTION = "MakeUserInstruction";
    private List<Entry<String, Pattern>> mySymbols;
    private static final String TURTLE_COMMANDS_RESOURCE = "Controller/TurtleCommands";
    private static final String NUM_CHILDREN_PER_COMMAND = "Controller/NumChildrenForFunction";
    private static final String MODEL = "Model.";
    private ResourceBundle myNumChildrenPerCommand;
    private ResourceBundle myTurtleCommands;
    private List<Turtle> myCurTurtles;
    private VariableDictionary varDict;
    private CommandDictionary commandDict;

    public Parser(CommandDictionary myComDict, VariableDictionary myVarDict) {
        mySymbols = new ArrayList<>();
        myNumChildrenPerCommand = ResourceBundle.getBundle(NUM_CHILDREN_PER_COMMAND);
        myTurtleCommands = ResourceBundle.getBundle(TURTLE_COMMANDS_RESOURCE);
        varDict = myVarDict;
        commandDict = myComDict;
    }
    
    /**
     * From regex example
     *
     * @param syntax: path to properties file.
     */
    public void addPatterns(String syntax) {
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            mySymbols.add(new SimpleEntry<>(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
    }

    public void clearAllPatterns() {
        mySymbols.clear();
    }

    public String getSymbol(String text) {
        final String ERROR = "NO MATCH";
        for (Entry<String, Pattern> e : mySymbols) {
            if (match(text, e.getValue())) {
                return e.getKey();
            }
        }
        return ERROR;
    }

    // given text, determines corresponding function
    private String parseText(String text) {
        if (text.trim().length() > 0) {
            return getSymbol(text);
        } else {
            //error
            return "";
        }
    }

    public IFunctions createCommandTree(List<String> commandList, List<Turtle> curTurtles) throws ClassNotFoundException {
        myCurTurtles = curTurtles;
        return createCommandTreeFromList(commandList);
    }

    private IFunctions createCommandTreeFromList(List<String> inputCommandList) throws ClassNotFoundException {
        IFunctions head = null;
        String commandToBuild = inputCommandList.get(0);
        head = createClass(commandToBuild, inputCommandList);

        return head;
    }

    public CommandList createList(List<String> inputList) throws ClassNotFoundException {
        CommandList list = new CommandList();
        // assumes there is a list end; if not we gotta through an error
        while (!(parseText(inputList.get(0))).equals(LIST_END)) {
        	Node head;
        	if (parseText(inputList.get(0)).equals(LIST_START)) {
        		inputList.remove(0);
        		head = createList(inputList);
        	} else {
        		head = createClass(inputList.get(0), inputList);
        	}
            list.addChild(head);
        }

        inputList.remove(0);
        return list;
    }

    private Node createClass(String commandToBuild, List<String> inputCommandList) throws ClassNotFoundException {
        String name = parseText(commandToBuild);
        Node node = null;
        inputCommandList.remove(0);
        switch (name) {
            case CONSTANT:
                node = new Constant(Integer.parseInt(commandToBuild));
                break;
            case VARIABLE:
                node = new Variable(commandToBuild);
                break;
            case COMMENT:
                break;
            case LIST_START:
            	node = createList(inputCommandList);
            	break;
            case COMMAND:
                node = handleCommand(commandToBuild, inputCommandList);
                break;
            case MAKE_USER_INSTRUCTION:
                node = new MakeUserInstruction(inputCommandList.get(0));
                node.setNumChildrenNeeded(Integer.parseInt(myNumChildrenPerCommand.getString(name)));
                inputCommandList.remove(0);
                addChildrenToNode(node, inputCommandList);
                break;
            default:
                node = getFunctionObject(name);
                addChildrenToNode(node, inputCommandList);
                break;
        }
        return node;
    }

    private Node handleCommand(String commandToBuild, List<String> inputCommandList) throws ClassNotFoundException {
        Node node;
        if (commandDict.contains(commandToBuild)) {
            node = commandDict.getCommandFor(commandToBuild);
            node.setNumChildrenNeeded(commandDict.getNumArgsForkey(commandToBuild));
            addChildrenToNode(node, inputCommandList);
        } else {
            node = new Command(commandToBuild);
        }
        return node;
    }

    private Node getFunctionObject(String name) throws ClassNotFoundException {
        Node myNode;
        Class className = Class.forName(MODEL + name);
        try {
            myNode = (Node) className.newInstance();
            myNode.setNumChildrenNeeded(Integer.parseInt(myNumChildrenPerCommand.getString(name)));
            if (Arrays.asList(myTurtleCommands.getString(TURTLE_COMMANDS).split(",")).contains(name)) {
                myNode.setTurtleList(myCurTurtles);
            }
            return myNode;
        } catch (Exception e) {
            //error
        }
        return null;
    }

    private void addChildrenToNode(Node node, List<String> inputCommandList) throws ClassNotFoundException {
        for (int i = 0; i < node.getNumChildrenNeeded(); i++) {
            Node childNode = createClass(inputCommandList.get(0), inputCommandList);
            if (childNode != null) {
                node.addChild(childNode);
            }
        }
    }

    private boolean match(String text, Pattern regex) {
        return regex.matcher(text).matches();
    }

    public VariableDictionary getVariables() {
        return varDict;
    }
}
