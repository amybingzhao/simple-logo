package Controller;

import java.util.ArrayList;
import java.util.List;

import GUIPackage.GUIAlert;
import GUIPackage.GUIOutput;
import Model.IFunctions;
import Model.Node;
import Model.Turtle;

/**
 * This class is the only external-facing back end class. It facilitates the interaction between the front end and back end
 * by processing the commands inputed by the user in the front end.
 *
 * @author amyzhao
 * @author blakekaplan
 */
public class Controller {

    private static final String SYNTAX_RESOURCE = "resources/languages/Syntax";
    private static final String DEFAULT_LANGUAGE_RESOURCE = "resources/languages/English";
    private static final String LANGUAGE_RESOURCE_LOCATION = "resources/languages/";
    public static final String DOES_NOT_EXIST = "DoesNotExist";
    public static final String EXECUTION_ERROR = "ExecutionError";
    public static final String INVALID_SYNTAX = "InvalidSyntax";
    private String myLanguageResource;
    private Parser myParser;
    private List<Turtle> myTurtles;
    private List<String> myCommandHistory;
    private int myCanvasWidth;
    private int myCanvasHeight;
    private Turtle myTurtle;
    private GUIOutput myOutput;
    private GUIAlert myAlert;
    private final String WHITESPACE = "\\p{Space}";

    /**
     * Initializes the controller.
     */
    public void init(int canvasHeight, int canvasWidth, Turtle t) {
        myCanvasWidth = canvasWidth;
        myCanvasHeight = canvasHeight;
        myParser = new Parser();
        myLanguageResource = DEFAULT_LANGUAGE_RESOURCE;
        myParser.addPatterns(myLanguageResource);
        myParser.addPatterns(SYNTAX_RESOURCE);
        myCommandHistory = new ArrayList<String>();
        myTurtles = new ArrayList<Turtle>();
        myTurtle = t;
        myOutput = new GUIOutput();
        myAlert = new GUIAlert();
    }

    /**
     * Sets the parser language.
     * @param lang: user-selected language.
     */
    public void setLanguage(String lang) {
    	myLanguageResource = LANGUAGE_RESOURCE_LOCATION + lang;
    	myParser.clearAllPatterns();
    	myParser.addPatterns(myLanguageResource);
    	myParser.addPatterns(SYNTAX_RESOURCE);
    }
    
    /**
     * Processes the command.
     *
     * @param command: String inputed by user to the command line.
     * @throws ClassNotFoundException
     */
    public void processCommand(String command){
    	List<String> commandAsList = getCommandAsList(command);
    	while (!commandAsList.isEmpty()) {
    		try{
    			//System.out.println("command: " + command);
    			//List<IFunctions> commands = myParser.createCommandTree(command, myTurtle);
    			IFunctions commandToExecute = myParser.createCommandTree(commandAsList, myTurtle);
    			double result = executeCommandTree(commandToExecute);
    			myOutput.setOutputText(Double.toString(result));
    			addCommandToHistory(command);
    		}
    		catch(ClassNotFoundException e){
    			myAlert.displayAlert(DOES_NOT_EXIST);
    		}
    		catch(IndexOutOfBoundsException e){
    			myAlert.displayAlert(INVALID_SYNTAX);
    		}
    		catch(NullPointerException e){
    			myAlert.displayAlert(EXECUTION_ERROR);
    		}
    	}
    }

    // converts string command to arraylist
    private List<String> getCommandAsList(String command) {
        List<String> inputCommandList = new ArrayList<String>();
        String[] inputArray = command.split(WHITESPACE);
        for (int i = 0; i < inputArray.length; i++) {
        	if (!inputArray[i].isEmpty()) {
        		inputCommandList.add(inputArray[i]);
        	}
        }
        return inputCommandList;
    }

    private double executeCommandTree(IFunctions head) throws ClassNotFoundException {
    	double result = 0;
    	System.out.println(head.toString());
    	result = head.interpret();
    	System.out.println(myTurtle.printPosition());
    	return result;
    }


    private void addCommandToHistory(String command) {
        myCommandHistory.add(command);
    }

    public List<String> getCommandHistory() {
        return myCommandHistory;
    }
    
    public GUIOutput getGUIOutput(){
    	return myOutput;
    }
    
    public void displayAlert(String errorResourceKey){
    	myAlert.displayAlert(errorResourceKey);
    }

}
