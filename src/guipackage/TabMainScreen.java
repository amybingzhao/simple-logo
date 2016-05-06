/**
 * Modified for VOOGASalad addition
 */

// This entire file is part of my masterpiece.
// Annie Tang
/**
 * Purpose: This class sets up the main workspace and places the GUI elements on the screen, utilizing
 * the GUIFactory class I created. 
 * 
 * Why it's good: All the methods are short and succinct and only do what the method name suggests.
 * I think this demonstrates well the idea of separating functionality. The class itself is also not overly
 * large. It only contains what is strictly needed in the main Tab. There are also no magic values, because
 * all the Strings are either constants of ResourceBundle String keys. Finally, instead of containing instantiation
 * details for EVERY GUI object that is placed into the workspace, this class utilizes a separate Factory class to
 * hide these details and keep the code readable.  
 */

package guipackage;

import controller.Controller;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

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
	private GUIFactory myFactory;
	private CanvasMain canvas;
	private GUICommandLine commandLine;
	private Controller myController;
	private GUILabeled myOutput;
	
	private IGUIObject userCommands;
	private IGUIObject previousCommands;
	private IGUIObject variables;
	private IGUIObject languageSelector;
	private IGUIObject saveLoad;
	private IGUIObject showHide;
	private IGUIObject animationControl;

    private Stage myStage;
    private String tabText;
       
    public TabMainScreen(String tabText){
    	this.tabText = tabText;
    }
	
	/**
	 * Sets up all elements on Tab and returns the Tab
	 * @return
	 */
	protected Tab getTab(Stage stage) {
		initializeTab(stage);
		myRootTab = new Tab();
		myMainScreen = new BorderPane();
		myFactory = new GUIFactory(myResources, myController, canvas, commandLine); 
		
		setCenterPane();
		setBottomPane();
		setLeftPane();
		setRightPane();
		setTopPane();
		
		myRootTab.setContent(myMainScreen);
		myRootTab.setText(tabText);
		return myRootTab;
	}
	
	/**
	 * Initializes Tab with all necessary components.
	 */
	private void initializeTab(Stage stage) {
        myStage = stage;
		this.myResources = ResourceBundle.getBundle(GUI_RESOURCE);
		canvas = new CanvasMain(myResources);
		myController = new Controller(canvas, myStage);
		commandLine = new GUICommandLine(myController, myResources, this);
	}
	
	/**
	 * Set center pane of BorderPane.
	 */
	private void setCenterPane() {
		myMainScreen.setCenter(canvas.getNode());
	}
	/**
	 * Set left pane of BorderPane.
	 */
	private void setLeftPane() {
		VBox leftPanel = new VBox(PANEL_PADDING);
		userCommands = myFactory.createNewGUIObject("UserCommands");
		previousCommands = myFactory.createNewGUIObject("PreviousCommands");
		languageSelector = myFactory.createNewGUIObject("LanguageSelector");
		saveLoad = myFactory.createNewGUIObject("SaveLoad");
		showHide = myFactory.createNewGUIObject("ShowHide");
		animationControl = myFactory.createNewGUIObject("AnimationControl");
		leftPanel.getChildren().addAll(userCommands.createNode(), 
				previousCommands.createNode(), languageSelector.createNode(), 
				saveLoad.createNode(), showHide.createNode(), animationControl.createNode());
		myMainScreen.setLeft(leftPanel);
	}
	/**
	 * Set right pane of BorderPane.
	 */
	private void setRightPane() {
		VBox rightPanel = new VBox(PANEL_PADDING);
		variables = myFactory.createNewGUIObject("Variables");
		rightPanel.getChildren().addAll(variables.createNode());
		myMainScreen.setRight(rightPanel);
	}
	/**
	 * Set bottom pane of BorderPane.
	 */
	private void setBottomPane(){
		myMainScreen.setBottom(commandLine.createNode());
	}
	/**
	 * Set top pane of BorderPane.
	 */
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
	}
}
