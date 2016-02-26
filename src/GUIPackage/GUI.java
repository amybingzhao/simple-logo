package GUIPackage;
import Controller.Controller;
import Model.Turtle;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GUI implements GUIInterface {
	private Scene myScene;
	private GridPane myRoot;
	private ResourceBundle myResources;
	private GUIObjectFactory myFactory;
	private Controller myController;
	private Turtle myTurtle;
	private TurtleObserver myObserver;
	
	private GUICanvasAndOptions canvas;
	
	//creating GUIObject instance variables
	private Node commandLine;
	private Node userCommands;
	private Node previousCommands;
	private Node variables;
	private Node exceptionHandler;
	private Node languageSelector;
	private Node penInput;
	private Node backgroundInput;
	private Node imageInput;
	
	private List<Node> myNodeList;
	
	
	private int windowHeight;
	private int windowWidth;
	
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	
	public GUI(int width, int height, String language) {
		windowWidth = width;
		windowHeight = height;
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
	}
	
	public Scene createScene() {
		//create Turtle and Observer
		myTurtle = new Turtle();
		myObserver = new TurtleObserver();
		myTurtle.addObserver(myObserver);
		
		canvas = new GUICanvasAndOptions(myController, myResources, "CanvasX", "CanvasY");
		myRoot = new GridPane();
		initializeNodes();
		for (Node node: myNodeList) {
			myRoot.add(node, 1, 1);
		}
		myScene = new Scene(myRoot, windowHeight, windowWidth, Color.WHITE);
		return myScene;
	}
	
	//TODO: Add in all nodes
	public void initializeNodes() {
		commandLine = myFactory.createNewGUIObject("CommandLine").createNode();
		userCommands = myFactory.createNewGUIObject("UserCommands").createNode();
		previousCommands = myFactory.createNewGUIObject("PreviousCommands").createNode();
		variables = myFactory.createNewGUIObject("Variables").createNode();
		exceptionHandler = myFactory.createNewGUIObject("ExceptionHandler").createNode();
		languageSelector = myFactory.createNewGUIObject("LanguageSelector").createNode();
		penInput = myFactory.createNewGUIObject("PenInput").createNode();
		backgroundInput = myFactory.createNewGUIObject("BackgroundInput").createNode();
		imageInput = myFactory.createNewGUIObject("ImageInput").createNode();
		
		myNodeList.addAll(Arrays.asList(commandLine, userCommands, previousCommands,
				variables, exceptionHandler, languageSelector, penInput, backgroundInput, imageInput));
	}

	@Override
	public int getWidth() {
		return windowWidth;
	}

	@Override
	public int getHeight() {
		return windowHeight;
	}

	@Override
	public void notifyAllObservers() {
		myTurtle.notifyObservers();
	}

}
