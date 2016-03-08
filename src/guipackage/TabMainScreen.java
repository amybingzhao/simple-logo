package guipackage;

import controller.Controller;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import model.Turtle;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
/**
 * Create tab for main screen (canvas, command line, options, etc.) 
 * @author AnnieTang
 *
 */

public class TabMainScreen {
	private static final String GUI_RESOURCE = "GUI";
	private static final int PANEL_PADDING = 10;
	private Tab myRootTab;
	private BorderPane myMainScreen;
	private ResourceBundle myResources;
	private GUIObjectFactory myFactory;
	private GUICanvas canvas;
	private GUICommandLine commandLine;
	private Controller myController;
	private GUIObjectLabeled myOutput;
	
	//GUIObject instance variables
	private IGUIObject userCommands;
	private IGUIObject previousCommands;
	private IGUIObject variables;
	private IGUIObject languageSelector;
	private IGUIObject imageInput;
	private GUIObjectComboBoxColor backgroundColorPalette;
	private GUIObjectComboBoxColor penColorPalette;
	private IGUIObject turtleState;
	private IGUIObject penSettings;
	private IGUIObject saveLoad;
	
	/**
	 * Initializes Tab with all necessary components.
	 */
	private void initializeTab() {
		//create Turtle and Observer
		this.myResources = ResourceBundle.getBundle(GUI_RESOURCE);
		canvas = new GUICanvas(myResources);
		canvas.init();
		myController = new Controller(canvas);
		commandLine = new GUICommandLine(myController, myResources, this);
	}
	
	/**
	 * Sets up all elements on Tab and returns the Tab
	 * @return
	 */
	protected Tab getTab() {
		initializeTab();
		myRootTab = new Tab();
		myMainScreen = new BorderPane();
		myFactory = new GUIObjectFactory(myResources, myController, canvas, commandLine); 
		
		setCenterPane();
		setBottomPane();
		setLeftPane();
		setRightPane();
		setTopPane();
		
		myRootTab.setContent(myMainScreen);
		return myRootTab;
	}
	
	/**
	 * Next 5 methods all place GUIObjects on the Pane.
	 */
	private void setCenterPane() {
		Node canvasNode = canvas.createNode();
		penSettings = myFactory.createNewGUIObject("PenSettings");
		canvas.addNodeToCanvasRight(penSettings.createNode());
		myMainScreen.setCenter(canvasNode);
	}

	private void setLeftPane() {
		VBox leftPanel = new VBox(PANEL_PADDING);
		turtleState = myFactory.createNewGUIObject("TurtleState");
		userCommands = myFactory.createNewGUIObject("UserCommands");
		previousCommands = myFactory.createNewGUIObject("PreviousCommands");
		languageSelector = myFactory.createNewGUIObject("LanguageSelector");
		imageInput = myFactory.createNewGUIObject("ImageComboBox");
		saveLoad = myFactory.createNewGUIObject("SaveLoad");
		leftPanel.getChildren().addAll(turtleState.createNode(),userCommands.createNode(), 
				previousCommands.createNode(), languageSelector.createNode(), 
				imageInput.createNode(), saveLoad.createNode());
		myMainScreen.setLeft(leftPanel);
	}
	
	private void setRightPane() {
		VBox rightPanel = new VBox(PANEL_PADDING);
		variables = myFactory.createNewGUIObject("Variables");
		rightPanel.getChildren().addAll(variables.createNode());
		myMainScreen.setRight(rightPanel);
	}
	
	private void setBottomPane(){
		myMainScreen.setBottom(commandLine.createNode());
	}

	private void setTopPane() {
		myOutput = myController.getGUIOutput();
		myMainScreen.setTop(myOutput.createNode());
	}
	
	/**
	 * Updates the necessary GUI elements when called.
	 */
	protected void updateGUI() {
		userCommands.updateNode();
		previousCommands.updateNode();
		variables.updateNode();
		turtleState.updateNode();
	}
}
