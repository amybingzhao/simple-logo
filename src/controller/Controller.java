package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import guipackage.GUIAlert;
import guipackage.GUICanvas;
import guipackage.GUIObjectLabeled;
import guipackage.GUIOutput;
import model.CommandDictionary;
import model.IFunctions;
import model.Turtle;
import model.VariableDictionary;

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
    private static final String GUI_RESOURCE = "GUI";
    private String myLanguageResource;
    private Parser myParser;
    private List<Turtle> myTurtles;
    private List<String> myCommandHistory;
    private final String WHITESPACE = "\\p{Space}";
    private GUICanvas myCanvas;
    private int myCanvasWidth;
    private int myCanvasHeight;
    private Turtle myTurtle;
    private GUIObjectLabeled myOutput;
    private GUIAlert myAlert;
    private ResourceBundle myGUIResource;
    private CommandDictionary commandDict;
    private VariableDictionary varDict;

    public Controller(GUICanvas canvas) {
    	myCanvas = canvas;
    	init();
    }
    
    /**
     * Initializes the controller.
     */
    public void init() {
        myLanguageResource = DEFAULT_LANGUAGE_RESOURCE;
        myCommandHistory = new ArrayList<String>();
        myTurtles = new ArrayList<Turtle>();
        addInitialTurtle();
        myGUIResource = ResourceBundle.getBundle(GUI_RESOURCE);
        myOutput = new GUIObjectLabeled(myGUIResource,"Output");
        myAlert = new GUIAlert();
        commandDict = new CommandDictionary();
        varDict = new VariableDictionary();
        myParser = new Parser(commandDict, varDict);
        myParser.addPatterns(myLanguageResource);
        myParser.addPatterns(SYNTAX_RESOURCE);
    }
    
    public void addInitialTurtle() {
    	Turtle turtle = new Turtle(0);
    	turtle.activate();
    	turtle.addObserver(myCanvas);
    	myTurtles.add(turtle);
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
    			IFunctions commandToExecute = myParser.createCommandTree(commandAsList, myTurtles);
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
    	result = head.interpret(commandDict, varDict);
    	addObserverToNewTurtles();
    	return result;
    }

    private void addObserverToNewTurtles() {
    	for (int i = 0; i < myTurtles.size(); i++) {
    		myTurtles.get(i).addObserver(myCanvas);
    		myTurtles.get(i).updateObservers();
    	}
    }
    
    public List<Turtle> getTurtles() {
    	return myTurtles;
    }

    private void addCommandToHistory(String command) {
        myCommandHistory.add(command);
    }

    public List<String> getCommandHistory() {
        return myCommandHistory;
    }
    
    public GUIObjectLabeled getGUIOutput(){
    	return myOutput;
    }
    
    public void displayAlert(String errorResourceKey){
    	myAlert.displayAlert(errorResourceKey);
    }

    public CommandDictionary getCommandDictionary(){
        return commandDict;
    }

    public VariableDictionary getVariableDictionary(){
        return varDict;
    }

}
