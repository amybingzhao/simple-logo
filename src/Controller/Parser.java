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

    public static final String CONSTANT = "Constant";
    public static final String VARIABLE = "Variable";
    public static final String COMMENT = "Comment";
    public static final String LIST_START = "ListStart";
    public static final String LIST_END = "ListEnd";
    public static final String TURTLE_COMMANDS = "TurtleCommands";
    public static final String MAKE = "MakeVariable";
    private List<Entry<String, Pattern>> mySymbols;
    private static final String TURTLE_COMMANDS_RESOURCE = "Controller/TurtleCommands";
    private static final String NUM_CHILDREN_PER_COMMAND = "Controller/NumChildrenForFunction";
    private static final String MODEL = "Model.";
    private final String WHITESPACE = "\\p{Space}";
    private ResourceBundle myNumChildrenPerCommand;
    private ResourceBundle myTurtleCommands;
    private Turtle myTurtle;
    private VariableDictionary myVars;

    public Parser() {
        mySymbols = new ArrayList<>();
        myNumChildrenPerCommand = ResourceBundle.getBundle(NUM_CHILDREN_PER_COMMAND);
        myTurtleCommands = ResourceBundle.getBundle(TURTLE_COMMANDS_RESOURCE);
        myTurtle = new Turtle();
        myVars = new VariableDictionary();
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

    public List<Node> createCommandTree(String command, Turtle turtle) throws ClassNotFoundException {
        myTurtle = turtle;
        List<String> inputCommandList = getCommandAsList(command);

        return createCommandTreeFromList(inputCommandList);
    }

    private List<Node> createCommandTreeFromList(List<String> inputCommandList) throws ClassNotFoundException {

        List<Node> headNodes = new ArrayList<Node>();
        while (!inputCommandList.isEmpty()) {
            String commandToBuild = inputCommandList.get(0);
            Node head = createClass(commandToBuild, inputCommandList);
            headNodes.add(head);
        }

        return headNodes;
    }
    
    public CommandList createList(List<String> inputList, Turtle turtle) throws ClassNotFoundException {
        myTurtle = turtle;
        CommandList list = new CommandList();
        String name;
        // assumes there is a list end; if not we gotta through an error
        while (!(name = parseText(inputList.get(0))).equals(LIST_END)) {
            Node head = createClass(inputList.get(0), inputList);
            list.addChild(head);
        }

        inputList.remove(0);
        return list;
    }

    private Node createClass(String commandToBuild, List<String> inputCommandList) throws ClassNotFoundException {
        String name = parseText(commandToBuild);
        Node node = null;
        inputCommandList.remove(0);
        Class className;
        
        switch (name){
            case CONSTANT:
                className = Class.forName(MODEL + name);
                node = new Constant(Integer.parseInt(commandToBuild.toString()));
                break;
            case VARIABLE:
                node = VariableDictionary.getNodeFor(commandToBuild);
                break;
            case COMMENT:
                break;
            case LIST_START:
            	node = createList(inputCommandList, myTurtle);
            	break;
            case MAKE:
                String varName = inputCommandList.get(0);
                inputCommandList.remove(0);
                Node expressionNode = createClass(inputCommandList.get(0), inputCommandList);
                node = handleMake(varName, expressionNode);
                break;
            default:
            	className = Class.forName(MODEL + name);
                try {
                    node = (Node) className.newInstance();
                    node.setNumChildrenNeeded(Integer.parseInt(myNumChildrenPerCommand.getString(name)));
                } catch (Exception e) {
                    //error
                }
                if (Arrays.asList(myTurtleCommands.getString(TURTLE_COMMANDS).split(",")).contains(name)) {
                    node.addTurtle(myTurtle);
                }
                addChildrenToNode(node, inputCommandList);
                break;
        }
        return node;
    }


    private void addChildrenToNode(Node node, List<String> inputCommandList) throws ClassNotFoundException {
        for (int i = 0; i < node.getNumChildrenNeeded(); i++) {
            Node childNode = createClass(inputCommandList.get(0), inputCommandList);
            if (childNode != null) {
                node.addChild(childNode);
            }
        }
    }

    private Node handleMake(String key, Node expression){

        MakeVariable myMakeNode;
        myMakeNode = new MakeVariable();
        myMakeNode.setName(key);
        myMakeNode.addChild(expression);
        return myMakeNode;
    }

    // converts string command to arraylist
    private List<String> getCommandAsList(String command) {
        List<String> inputCommandList = new ArrayList<String>();
        String[] inputArray = command.split(WHITESPACE);
        for (int i = 0; i < inputArray.length; i++) {
            inputCommandList.add(inputArray[i]);
        }
        return inputCommandList;
    }

    private boolean match(String text, Pattern regex) {
        return regex.matcher(text).matches();
    }

    private void addNewUserDefinedCommand() {
        // add name of new command + # args to numargs map

        // add string of the entire command to userdefinedcommands map
    }

    private void executeUserDefinedCommand() {
        //replace parameters with values before giving it back to the controller, e.g. for dash - replace all instances of
        // count and size with vals for count and size, then send that to parseCommand ^
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

}
