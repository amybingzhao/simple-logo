package GUIPackage;
import Controller.Controller;
import Model.Turtle;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class GUI implements GUIInterface {
	private static final int CANVAS_ROW_SPAN = 3;
	private Scene myScene;
	private TabPane myRoot;
	private ResourceBundle myResources;
	private GUIObjectFactory myFactory;
	private Controller myController;
	private Turtle myTurtle;
	private TurtleObserver myObserver;
	
	private GUICanvasAndOptions canvas;
	
	private int windowHeight;
	private int windowWidth;
	
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	
//	public GUI(int width, int height, String language) {
//		windowWidth = width;
//		windowHeight = height;
//		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
//	}
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
		
		TabMainScreen mainScreenTab = new TabMainScreen(myController, canvas);
		myRoot.getTabs().add(mainScreenTab.getTab());		
	
		myScene = new Scene(myRoot, windowHeight, windowWidth, Color.WHITE);
		return myScene;
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