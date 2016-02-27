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
	private static final int CANVAS_ROW_SPAN = 3;
	private Scene myScene;
	private GridPane myRoot;
	private ResourceBundle myResources;
	private GUIObjectFactory myFactory;
	private Controller myController;
	private Turtle myTurtle;
	private TurtleObserver myObserver;
	
	private GUICanvasAndOptions canvas;
	
	//creating GUIObject instance variables
	private GUIObject commandLine;
	private GUIObject userCommands;
	private GUIObject previousCommands;
	private GUIObject variables;
	private GUIObject exceptionHandler;
	private GUIObject languageSelector;
	private GUIObject penInput;
	private GUIObject backgroundInput;
	private GUIObject imageInput;
	
	private List<GUIObject> myNodeList;
	
	
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
		
		myFactory = new GUIObjectFactory(myController, canvas);
		myRoot = new GridPane();
		initializeNodes();
		for (GUIObject object: myNodeList) {
			myRoot.add(object.createNode(), object.getXPos(), object.getYPos());
		}
		myScene = new Scene(myRoot, windowHeight, windowWidth, Color.WHITE);
		return myScene;
	}
	
	private void addCanvas() {
		canvas = new GUICanvasAndOptions(myController, myResources, "CanvasX", "CanvasY");
		Node canvasNode = canvas.createNode();
		myRoot.add(canvasNode, canvas.getXPos(), canvas.getYPos());
		myRoot.setRowSpan(canvasNode, CANVAS_ROW_SPAN);
	}
	
	//TODO: Add in all nodes
	public void initializeNodes() {
		commandLine = myFactory.createNewGUIObject("CommandLine");
		userCommands = myFactory.createNewGUIObject("UserCommands");
		previousCommands = myFactory.createNewGUIObject("PreviousCommands");
		variables = myFactory.createNewGUIObject("Variables");
		exceptionHandler = myFactory.createNewGUIObject("ExceptionHandler");
		languageSelector = myFactory.createNewGUIObject("LanguageSelector");
		penInput = myFactory.createNewGUIObject("PenInput");
		backgroundInput = myFactory.createNewGUIObject("BackgroundInput");
		imageInput = myFactory.createNewGUIObject("ImageInput");
		
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
