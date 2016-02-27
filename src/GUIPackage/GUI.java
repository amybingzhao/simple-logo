package GUIPackage;
import Controller.Controller;
import Model.Turtle;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;

public class GUI implements GUIInterface {
	private Scene myScene;
	private TabPane myRoot;
	private ResourceBundle myResources;
	private Controller myController;
	private Turtle myTurtle;
	private TurtleObserver myObserver;
	
	private GUICanvasAndOptions canvas;
	
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