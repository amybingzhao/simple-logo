package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Constant;
import Model.Node;
import Model.Turtle;
import Model.Variable;

/**
 * This class is the only external-facing back end class. It facilitates the interaction between the front end and back end
 * by processing the commands inputed by the user in the front end.
 * @author amyzhao
 *
 */
public class Controller {

	private static final String SYNTAX_RESOURCE = "resources/languages/Syntax";
	private static final String LANGUAGE_RESOURCE = "resources/languages/English";
	private static final String MODEL = "Model.";
	private final String WHITESPACE = "\\p{Space}";
	private Parser myParser;
	private List<Turtle> myTurtles;
	private List<String> myCommandHistory;
	private int myCanvasWidth;
	private int myCanvasHeight;
	private List<Variable> myVariableList; //is a turtle a variable?

	/**
	 * Initializes the controller.
	 */
	public void init(int canvasHeight, int canvasWidth) {
		myCanvasWidth = canvasWidth;
		myCanvasHeight = canvasHeight;
		myParser = new Parser();
		myParser.addPatterns(LANGUAGE_RESOURCE);
		myParser.addPatterns(SYNTAX_RESOURCE);
		myCommandHistory = new ArrayList<String>();
		myTurtles = new ArrayList<Turtle>();
		myVariableList = new ArrayList<Variable>();
	}
	
	/**
	 * Processes the command.
	 * @param s: String inputed by user to the command line.
	 * @throws ClassNotFoundException 
	 */
	public void processCommand(String command) throws ClassNotFoundException {
		List<Node> commands = createCommandTree(command);
		executeCommandTree(commands);
	}

	// given text, determines corresponding function 
	private static String parseText (Parser lang, String text) {
		if (text.trim().length() > 0) {
			return lang.getSymbol(text);
		} else {
			//error
			return "";
		}
	}
	
	private void executeCommandTree(List<Node> headNodes) {
		for (int i = 0; i < headNodes.size(); i++) {
			Node head = headNodes.get(i);
			System.out.println(head.toString());
			head.interpret();
			System.out.println("result: " + Integer.toString(head.interpret()));
			myCommandHistory.add(head.toString());
		}
	}
	
	// should add to command history as well
	private List<Node> createCommandTree(String command) throws ClassNotFoundException {
		List<Node> headNodes = new ArrayList<Node>();
		List<String> inputCommandList = getCommandAsList(command);
		
		while(!inputCommandList.isEmpty()) {
			String commandToBuild = inputCommandList.get(0);
			Node head = createClass(commandToBuild, inputCommandList);
			headNodes.add(head);
		}
		
		return headNodes;
	}
	
	//returns null if couldn't create the node
	private Node createClass(String commandToBuild, List<String> inputCommandList) throws ClassNotFoundException {
		Class className = Class.forName(MODEL + parseText(myParser, commandToBuild));
		Node node = null;
		inputCommandList.remove(0);

		if (className.getName().equals(MODEL + "Constant")) {
			node = new Constant(Integer.parseInt(commandToBuild.toString()));
		} else if (className.getName().equals(MODEL + "Variable")) { // how to handle creating variables..
			node = myVariableList.get(myVariableList.indexOf(commandToBuild));
		} else {
			try {
				node = (Node) className.newInstance();
			} catch (Exception e) {
				//error
			}
			addChildrenToNode(node, inputCommandList);
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
		for (int i =0 ; i < inputArray.length; i++) {
			inputCommandList.add(inputArray[i]);
		}
		return inputCommandList;
	}

	public void addCommandToHistory(String command) {
		myCommandHistory.add(command);
	}

	public List<String> getCommandHistory() {
		return myCommandHistory;
	}

}
