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

public class GUI implements GUIInterface {
	private static final String HELP_TAB_TEXT = "Help";
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

	public GUI(int width, int height) {
		windowWidth = width;
		windowHeight = height;
	}
	
	public Scene createScene() {
		//create Turtle and Observer
		myTurtle = new Turtle();
		myObserver = new TurtleObserver();
		myTurtle.addObserver(myObserver);
		
		myRoot = new TabPane();
		
		Tab mainScreenTab = new TabMainScreen(myController, canvas, commandLine).getTab();
		Tab helpTab = createHelpTab();
		
		myRoot.getTabs().addAll(mainScreenTab, helpTab);		
	
		myScene = new Scene(myRoot, windowHeight, windowWidth, Color.WHITE);
		return myScene;
	}

	private Tab createHelpTab(){
		Tab helpTab = new Tab();
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load("http://www.cs.duke.edu/courses/compsci308/spring16/assign/03_slogo/commands.php");
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