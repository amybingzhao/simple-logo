package GUIPackage;
import java.util.ResourceBundle;

import Controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
	private Controller myController;
	private Canvas canvas_background;
	private Canvas canvas;
	private GraphicsContext gc_background;
	private GraphicsContext gc;
	private ResourceBundle myResources;
	private TurtleObserver myTurtle;
	private Image turtleImage;
	
	public GUICanvas(Controller myController, ResourceBundle myResources, TurtleObserver turtle) {
		this.myController = myController;
		this.myResources = myResources;
		this.myTurtle = turtle;
	}

	public Node createNode() {
		canvas_background = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		gc_background = canvas_background.getGraphicsContext2D();
		gc_background.setFill(Color.BISQUE);
		gc_background.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
		return canvas_background;
	}

	public void updateNode() {
		drawTurtle();
		System.out.println(myTurtle.getX());
		System.out.println(myTurtle.getY());
	}
	
	//TODO: get the image from the file
	public void setImage(File file){
		String filePath = file.getPath();
		String[] splitFilePath = filePath.split(PATH_DELIMITER);
		String fileName = splitFilePath[splitFilePath.length - 1];
		turtleImage = new Image(getClass().getClassLoader().getResourceAsStream(fileName));
		drawTurtle();
	}
	
	public void drawTurtle() {
		gc.drawImage(turtleImage, myTurtle.getX(), myTurtle.getY(), TURTLE_SIZE, TURTLE_SIZE);
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
