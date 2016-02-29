package GUIPackage;
import Controller.Controller;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
/**
 * Create tab for main screen (canvas, command line, options, etc.) 
 * @author AnnieTang
 *
 */

public class TabMainScreen{
	private static final String GUI_RESOURCE = "GUI";
	private static final int LEFT_PANEL_PADDING = 10;
	private static final String TAB_TEXT = "Main";
	private Tab myRootTab;
	private BorderPane myMainScreen;
	private ResourceBundle myResources;
	private GUIObjectFactory myFactory;
	private GUICanvas canvas;
	private GUICommandLine commandLine;
	private Controller myController;
	private TurtleObserver myTurtle;
	private GUIOutput myOutput;
	
	//creating GUIObject instance variables
	private GUIObject userCommands;
	private GUIObject previousCommands;
	private GUIObject variables;
	private GUIObject exceptionHandler;
	private GUIObject languageSelector;
	private GUIObject imageInput;
	private GUIObject colorPickerBackground;
	private GUIObject colorPickerPen;
	

	public TabMainScreen(Controller myController, GUICanvas canvas, GUICommandLine cLine, TurtleObserver turtle) {
		this.myController = myController;
		this.canvas = canvas;
		this.commandLine = cLine;
		this.myTurtle = turtle;
	}

	public Tab getTab() {
		this.myResources = ResourceBundle.getBundle(GUI_RESOURCE);
		myRootTab = new Tab();
		myMainScreen = new BorderPane();
		
		setCenterPane();
		//must be after setCenterPane, or canvas will not have been instantiated yet 
		myFactory = new GUIObjectFactory(myResources, myController, canvas); 
		
		setLeftPane();
		setRightPane();
		setBottomPane();
		setTopPane();
		
		myRootTab.setContent(myMainScreen);
		myRootTab.setText(TAB_TEXT);
		return myRootTab;
	}

	private void setCenterPane() {
		canvas = new GUICanvas(myController, myResources, myTurtle);
		Node canvasNode = canvas.createNode();
		myMainScreen.setCenter(canvasNode);
	}

	private void setLeftPane() {
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
	
	//TODO:
	private void setRightPane() {
		variables = myFactory.createNewGUIObject("Variables");
		myMainScreen.setRight(variables.createNode());
	}
	//TODO:	
	private void setBottomPane(){
		commandLine = new GUICommandLine(myController, myResources, this);
		myMainScreen.setBottom(commandLine.createNode());
	}
	//TODO:	
	private void setTopPane() {
		myOutput = myController.getGUIOutput();
//		exceptionHandler = myFactory.createNewGUIObject("ExceptionHandler");
		myMainScreen.setTop(myOutput.createNode());
	}
	
	protected void updateGUI() {
		canvas.updateNode();
		userCommands.updateNode();
		previousCommands.updateNode();
		variables.updateNode();
	}
}
