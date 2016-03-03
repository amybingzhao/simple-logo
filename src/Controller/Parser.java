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
    private static final String MAKE = "MakeVariable";
    private static final String COMMAND = "Command";
    private static final String MAKE_USER_INSTRUCTION = "MakeUserInstruction";
    private List<Entry<String, Pattern>> mySymbols;
    private static final String TURTLE_COMMANDS_RESOURCE = "Controller/TurtleCommands";
    private static final String NUM_CHILDREN_PER_COMMAND = "Controller/NumChildrenForFunction";
    private static final String MODEL = "Model.";
    private final String WHITESPACE = "\\p{Space}";
    private ResourceBundle myNumChildrenPerCommand;
    private ResourceBundle myTurtleCommands;
    private Turtle myTurtle;
    private VariableDictionary myVariables;

    public Parser() {
        mySymbols = new ArrayList<>();
        myNumChildrenPerCommand = ResourceBundle.getBundle(NUM_CHILDREN_PER_COMMAND);
        myTurtleCommands = ResourceBundle.getBundle(TURTLE_COMMANDS_RESOURCE);
        myTurtle = new Turtle();
        myVariables = new VariableDictionary();
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

    public IFunctions createCommandTree(List commandList, Turtle turtle) throws ClassNotFoundException {
        myTurtle = turtle;
        return createCommandTreeFromList(commandList);
    }

    private IFunctions createCommandTreeFromList(List<String> inputCommandList) throws ClassNotFoundException {
    	IFunctions head = null;
    	String commandToBuild = inputCommandList.get(0);
    	head = createClass(commandToBuild, inputCommandList);

    	return head;
    }
    
    public CommandList createList(List<String> inputList, Turtle turtle) throws ClassNotFoundException {
        myTurtle = turtle;
        CommandList list = new CommandList();
        // assumes there is a list end; if not we gotta through an error
        while (!(parseText(inputList.get(0))).equals(LIST_END)) {
        	Node head;
        	if (parseText(inputList.get(0)).equals(LIST_START)) {
        		inputList.remove(0);
        		head = createList(inputList, turtle);
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
        switch (name){
            case CONSTANT:
                node = new Constant(Integer.parseInt(commandToBuild));
                break;
            case VARIABLE:
                node = new Variable(commandToBuild);
                break;
            case COMMENT:
                break;
            case LIST_START:
            	node = createList(inputCommandList, myTurtle);
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
        if(CommandDictionary.getInstance().contains(commandToBuild)){
            node = CommandDictionary.getInstance().getCommandFor(commandToBuild);
            node.setNumChildrenNeeded(CommandDictionary.getInstance().getNumArgsForkey(commandToBuild));
            addChildrenToNode(node, inputCommandList);
        }
        else {
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
                myNode.addTurtle(myTurtle);
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

    private String listToString(List<String> input) {

        String expression = "";

        for (String myString : input) {
            expression += myString;
            expression += " ";
        }

        return expression.trim();
    }

    private void handleVariable(String name, List<String> expressionList){

    }

    public VariableDictionary getVariables(){
        return myVariables;
    }
}
