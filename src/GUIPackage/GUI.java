package GUIPackage;
import Controller.Controller;
import Model.Turtle;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;

public class GUI implements GUIInterface {
	private Scene myScene;
	private GridPane myRoot;
	private ResourceBundle myResources;
//	private GUIObjectFactory myFactory;
	private Controller myController;
	private Turtle myTurtle;
	private TurtleObserver myObserver;
	
	private int windowHeight;
	private int windowWidth;

	private List<GUIObject> myNodeList;
	
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	
	public GUI(int width, int height, String language) {
		windowWidth = width;
		windowHeight = height;
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
	}
	
	public Scene createScene() {
		myTurtle = new Turtle();
		myObserver = new TurtleObserver();
		myTurtle.addObserver(myObserver);
		myRoot = new GridPane();
		initializeNodes();
		for (GUIObject object: myNodeList) {
			myRoot.add(object.createNode(myController, ""), 0, 0);
		}
		myScene = new Scene(myRoot, windowHeight, windowWidth, Color.WHITE);
		return myScene;
	}
	
	//TODO: Add in all nodes
	public void initializeNodes() {
		GUIObject command = new GUIObjectTableView();
		myNodeList.add(command);
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
