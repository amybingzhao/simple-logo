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
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
/**
 * Create tab for main screen (canvas, command line, options, etc.) 
 * @author AnnieTang
 *
 */
public class TabMainScreen{
	private static final String GUI_RESOURCE = "GUI";
	private static final int CANVAS_ROW_SPAN = 20;
	private static final int LEFT_PANEL_PADDING = 10;
	private Tab myRootTab;
	private BorderPane myMainScreen;
	private ResourceBundle myResources;
	private GUIObjectFactory myFactory;
	private GUICanvas canvas;
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
	private GUIObject colorPickerBackground;
	private GUIObject colorPickerPen;
	
	private List<GUIObject> myNodeList;
	
	public TabMainScreen(Controller myController, GUICanvas canvas) {
		this.myController = myController;
		this.canvas = canvas;
	}
	
	public Tab getTab() {
		this.myResources = ResourceBundle.getBundle(GUI_RESOURCE);
		myNodeList = new ArrayList<GUIObject>();
		myRootTab = new Tab();
		myMainScreen = new BorderPane();
		
		setCenterPane();
		//must be after setCenterPane, or canvas will not have been instantiated yet 
		myFactory = new GUIObjectFactory(myResources, myController, canvas); 
		
		setLeftPane();
		
		
		myRootTab.setContent(myMainScreen);
		return myRootTab;
	}
	
	public void createNodeList() {
		commandLine = myFactory.createNewGUIObject("CommandLine");
	
		variables = myFactory.createNewGUIObject("Variables");
		exceptionHandler = myFactory.createNewGUIObject("ExceptionHandler");
//		
//		myNodeList.addAll(Arrays.asList(commandLine, userCommands, previousCommands,
//				variables, exceptionHandler, languageSelector, imageInput));
		
		
	}
	
	private void setCenterPane() {
		canvas = new GUICanvas(myController, myResources);
		Node canvasNode = canvas.createNode();
		myMainScreen.setCenter(canvasNode);
	}
	
	private void setLeftPane(){
		VBox box = new VBox(LEFT_PANEL_PADDING);
		colorPickerBackground = myFactory.createNewGUIObject("ColorPickerBackground");
		colorPickerPen = myFactory.createNewGUIObject("ColorPickerPen");
		userCommands = myFactory.createNewGUIObject("UserCommands");
		previousCommands = myFactory.createNewGUIObject("PreviousCommands");
		languageSelector = myFactory.createNewGUIObject("LanguageSelector");
		imageInput = myFactory.createNewGUIObject("ImageInput");
		box.getChildren().addAll(colorPickerBackground.createNode(),
				colorPickerPen.createNode(),userCommands.createNode(), 
				previousCommands.createNode(), languageSelector.createNode(), 
				imageInput.createNode());
		myMainScreen.setLeft(box);
	}
}
