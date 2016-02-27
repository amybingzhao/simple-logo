package GUIPackage;
import Controller.Controller;
import Model.Turtle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class TabMainScreen{
	private static final String GUI_RESOURCE = "GUI";
	private static final int CANVAS_ROW_SPAN = 3;
	private Tab myRootTab;
	private GridPane myMainScreen;
	private ResourceBundle myResources;
	private GUIObjectFactory myFactory;
	private GUICanvasAndOptions canvas;
	private Controller myController;
	
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
	
	public TabMainScreen(Controller myController, GUICanvasAndOptions canvas) {
		this.myController = myController;
		this.canvas = canvas;
	}
	
	public Tab getTab() {
		this.myResources = ResourceBundle.getBundle(GUI_RESOURCE);
		myFactory = new GUIObjectFactory(myResources, myController, canvas);
		myNodeList = new ArrayList<GUIObject>();
		
		myRootTab = new Tab();
		
		myMainScreen = new GridPane();
		addCanvas();
		
		createNodeList();
		for (GUIObject object: myNodeList) {
			myMainScreen.add(object.createNode(), object.getXPos(), object.getYPos());
		}
		
		myRootTab.setContent(myMainScreen);
		return myRootTab;
	}
	
	public void createNodeList() {
//		commandLine = myFactory.createNewGUIObject("CommandLine");
//		userCommands = myFactory.createNewGUIObject("UserCommands");
//		previousCommands = myFactory.createNewGUIObject("PreviousCommands");
//		variables = myFactory.createNewGUIObject("Variables");
//		exceptionHandler = myFactory.createNewGUIObject("ExceptionHandler");
//		languageSelector = myFactory.createNewGUIObject("LanguageSelector");
//		imageInput = myFactory.createNewGUIObject("ImageInput");
//		
//		myNodeList.addAll(Arrays.asList(commandLine, userCommands, previousCommands,
//				variables, exceptionHandler, languageSelector, imageInput));
	
		previousCommands = myFactory.createNewGUIObject("PreviousCommands");
		exceptionHandler = myFactory.createNewGUIObject("ExceptionHandler");
		
		myNodeList.addAll(Arrays.asList(previousCommands, exceptionHandler));
		
	}
	
	private void addCanvas() {
		canvas = new GUICanvasAndOptions(myController, myResources, "CanvasX", "CanvasY");
		Node canvasNode = canvas.createNode();
		myMainScreen.add(canvasNode, canvas.getXPos(), canvas.getYPos());
		GridPane.setRowSpan(canvasNode, CANVAS_ROW_SPAN);
	}
}
