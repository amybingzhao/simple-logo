package guipackage;
import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import model.Turtle;

/**
 * Main GUI class. Creates main JavaFX components for GUI.
 * @author 
 *
 */
public class GUI implements IGUI {
	private static final String GUI_RESOURCE = "GUI";
	private static final String HELP_TAB_TEXT = "Help";
	private Scene myScene;
	private AnchorPane myRoot;
	private TabPane myTabs;
	private ResourceBundle myResources;
	private Turtle myTurtle;
	
	private int windowHeight;
	private int windowWidth;

	public GUI(int windowWidth, int windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.myResources = ResourceBundle.getBundle(GUI_RESOURCE);
	}
	
	/**
	 * Creates the scene to be put on the stage.
	 * @return GUI Scene
	 */
	public Scene createScene() {
		myRoot = new AnchorPane();
		myTabs = new TabPane();
		Button newTab = new Button("Create New Tab");
		newTab.setOnAction(event -> createNewTab());

		Tab mainScreenTab = new TabMainScreen().getTab();
		Tab helpTab = createHelpTab();
		
		myTabs.getTabs().addAll(mainScreenTab, helpTab);
		mainScreenTab.setText("Main Workspace");	
		
		AnchorPane.setTopAnchor(myTabs, 5.0);
		AnchorPane.setTopAnchor(newTab, 50.0);
		
		myRoot.getChildren().addAll(myTabs, newTab);
	
		myScene = new Scene(myRoot, windowHeight, windowWidth, Color.WHITE);
		return myScene;
	}
	
	/**
	 * Creates Help Tab for the user.
	 * @return Tab with all the commands
	 */
	private Tab createHelpTab() {
		Tab helpTab = new Tab();
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load(myResources.getString("HelpTabURL"));
		helpTab.setContent(browser);
		helpTab.setText(HELP_TAB_TEXT);
		return helpTab;
	}
	
	private void createNewTab() {
		Tab tab = new TabMainScreen().getTab();
        myTabs.getTabs().add(tab);
		tab.setText("Workspace " + (myTabs.getTabs().size() - 1));
        myTabs.getSelectionModel().select(tab);
	}
	
	/**
	 * Returns width of window
	 */
	@Override
	public int getWidth() {
		return windowWidth;
	}

	/**
	 * Returns height of window
	 */
	@Override
	public int getHeight() {
		return windowHeight;
	}
	
	/**
	 * Notifies the turtle's observers that the turtle has changed.
	 */
	@Override
	public void notifyAllObservers() {
		myTurtle.notifyObservers();
	}

}