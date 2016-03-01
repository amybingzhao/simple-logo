package GUIPackage;
import Controller.Controller;
import Model.Turtle;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class GUI implements IGUI {
	private static final String GUI_RESOURCE = "GUI";
	private static final String HELP_TAB_TEXT = "Help";
	private static final int CANVAS_WIDTH = 500;
	private static final int CANVAS_HEIGHT = 600;
	private Scene myScene;
	private TabPane myRoot;
	private ResourceBundle myResources;
	private Controller myController;
	private Turtle myTurtle;
	private TurtleObserver myObserver;
	
	private GUICanvas canvas;
	private GUICommandLine commandLine;
	
	private int windowHeight;
	private int windowWidth;

	public GUI(int windowWidth, int windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.myResources = ResourceBundle.getBundle(GUI_RESOURCE);
	}
	
	public Scene createScene() {
		//create Turtle and Observer
		myTurtle = new Turtle();
		myObserver = new TurtleObserver();
		myTurtle.addObserver(myObserver);
		myController = new Controller();
		myController.init(CANVAS_HEIGHT, CANVAS_WIDTH, myTurtle);
		
		myRoot = new TabPane();
		
		Tab mainScreenTab = new TabMainScreen(myController, canvas, commandLine, myObserver, myResources).getTab();
		Tab helpTab = createHelpTab();
		
		myRoot.getTabs().addAll(mainScreenTab, helpTab);		
	
		myScene = new Scene(myRoot, windowHeight, windowWidth, Color.WHITE);
		return myScene;
	}

	private Tab createHelpTab(){
		Tab helpTab = new Tab();
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load(myResources.getString("HelpTabURL"));
		helpTab.setContent(browser);
		helpTab.setText(HELP_TAB_TEXT);
		return helpTab;
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