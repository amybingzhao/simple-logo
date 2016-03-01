package GUIPackage;
import java.util.ResourceBundle;

import Controller.Controller;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import java.io.File;
/**
 * Returns one Node that contains the Turtle Canvas and two ColorPicker objects
 * (for background and pen)
 * @author AnnieTang
 *
 */
public class GUICanvas {
	private static final int TURTLE_SIZE = 20;
	private static final int CANVAS_WIDTH = 500;
	private static final int CANVAS_HEIGHT = 600;
	private static final String PATH_DELIMITER = "/";
	private static final String DEFAULT_TURTLE = "turtle_outline.png";
	private double myX;
	private double myY;
	private double myOldX;
	private double myOldY;
	private Controller myController;
	private Canvas canvas_background;
	private Canvas canvas;
	private GraphicsContext gc_background;
	private GraphicsContext gc;
	private ResourceBundle myResources;
	private TurtleObserver myTurtle;
	private Image turtleImage;
	private ImageView turtleIV;
	
	public GUICanvas(Controller myController, ResourceBundle myResources, TurtleObserver turtle) {
		this.myController = myController;
		this.myResources = myResources;
		this.myTurtle = turtle;
	}

	public Node createNode() {
		canvas_background = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		gc_background = canvas_background.getGraphicsContext2D();
		canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		gc_background.setFill(Color.BISQUE);
		gc_background.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
		addDefaultTurtle();
		Pane root = new Pane(canvas_background, canvas);
		return root;
	}

	public void updateNode() {
		drawTurtle();
	}
	
	private void addDefaultTurtle(){
		turtleImage = new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_TURTLE));
		turtleIV = new ImageView(turtleImage);
		drawTurtle();
	}
	
	//TODO: get the image from the file
	public void setImage(File file){
		String filePath = file.getPath();
		String[] splitFilePath = filePath.split(PATH_DELIMITER);
		String fileName = splitFilePath[splitFilePath.length - 1];
		turtleImage = new Image(getClass().getClassLoader().getResourceAsStream(fileName));
		turtleIV = new ImageView(turtleImage);
		drawTurtle();
	}
	
	public void drawTurtle() {
		gc.clearRect(myOldX, myOldY, TURTLE_SIZE, TURTLE_SIZE);
		myX = myTurtle.getX() + CANVAS_WIDTH/2;
		myY = -(myTurtle.getY() - CANVAS_HEIGHT/2);
		gc.save(); // saves the current state on stack, including the current transform
		Rotate r = new Rotate(myTurtle.getDirection(), myX + TURTLE_SIZE/2, myY + TURTLE_SIZE/2);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
		gc.drawImage(turtleIV.getImage(), myX, myY, TURTLE_SIZE, TURTLE_SIZE);
		gc.restore();
		myOldX = myX;
		myOldY = myY;
	}

	public GraphicsContext getBackgroundGraphicsContext(){
		return gc_background;
	}
	
	public int getWidth(){
		return CANVAS_WIDTH;
	}
	
	public int getHeight(){
		return CANVAS_HEIGHT;
	}
}
