package Controller;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import Model.Constant;
import Model.Node;
import Model.Turtle;
import Model.Variable;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * This class is used to parse command strings into Command objects.
 *
 * @author amyzhao
 * @author blakekaplan
 */
public class Parser {

    public static final String CONSTANT = "Constant";
    public static final String VARIABLE = "Variable";
    public static final String COMMENT = "comment";
    public static final String TURTLE_COMMANDS = "TurtleCommands";
    private List<Entry<String, Pattern>> mySymbols;
    private static final String TURTLE_COMMANDS_RESOURCE = "Controller/TurtleCommands";
    private static final String NUM_CHILDREN_PER_COMMAND = "Controller/NumChildrenForFunction";
    private static final String MODEL = "Model.";
    private final String WHITESPACE = "\\p{Space}";
    private ResourceBundle myNumChildrenPerCommand;
    private ResourceBundle myTurtleCommands;
    private List<Variable> myVariableList;
    private Turtle myTurtle;

    public Parser() {
        mySymbols = new ArrayList<>();
        myNumChildrenPerCommand = ResourceBundle.getBundle(NUM_CHILDREN_PER_COMMAND);
        myTurtleCommands = ResourceBundle.getBundle(TURTLE_COMMANDS_RESOURCE);
        myVariableList = new ArrayList<Variable>();
        myTurtle = new Turtle();

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
        List<Node> headNodes = new ArrayList<Node>();
        List<String> inputCommandList = getCommandAsList(command);

        while (!inputCommandList.isEmpty()) {
            String commandToBuild = inputCommandList.get(0);
            Node head = createClass(commandToBuild, inputCommandList);
            headNodes.add(head);
        }

        return headNodes;
    }

    private Node createClass(String commandToBuild, List<String> inputCommandList) throws ClassNotFoundException {
        String name = parseText(commandToBuild);
        Class className = Class.forName(MODEL + name);
        Node node = null;
        inputCommandList.remove(0);

        switch (className.getName()){
            case MODEL + CONSTANT:
                node = new Constant(Integer.parseInt(commandToBuild.toString()));
                break;
            case MODEL + VARIABLE:
                node = myVariableList.get(myVariableList.indexOf(commandToBuild));
                break;
            case MODEL + COMMENT:
                break;
            default:
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
}
