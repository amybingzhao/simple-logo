package guipackage;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import model.Turtle;

import java.io.File;

/**
 * Returns canvas for Turtle.
 *
 * @author AnnieTang
 */

public class GUICanvas implements Observer{
	private static final int TURTLE_SIZE = 20;
	private static final int CANVAS_WIDTH = 500;
	private static final int STARTING_X = CANVAS_WIDTH/2;
	private static final int CANVAS_HEIGHT = 500;
	private static final int STARTING_Y = CANVAS_HEIGHT/2;
	private static final String PATH_DELIMITER = "/";
	private static final String DEFAULT_TURTLE = "turtle_outline.png";
	private double myX;
	private double myY;
	private double myOldX;
	private double myOldY;
	private double myOldDirection;
	private Canvas canvasBackground;
	private Canvas canvasDrawing;
	private Canvas canvas;
	private GraphicsContext gcBackground;
	private GraphicsContext gcDrawing;
	private GraphicsContext gc;
	private Turtle myTurtle;
	private Image turtleImage;
	
	/**
	 * Creates the Canvas Node to be displayed.
	 * @return Canvas Node
	 */
	public Node createNode() {
		canvasBackground = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		gcBackground = canvasBackground.getGraphicsContext2D();
		canvasDrawing = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		gcDrawing = canvasDrawing.getGraphicsContext2D();
		canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		gcBackground.setFill(Color.BISQUE);
		gcBackground.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
		addDefaultTurtle();
		Pane root = new Pane(canvasBackground, canvasDrawing, canvas);
		return root;
	}
	
	/**
	 * Updates the Canvas when the Turtle is updated.
	 */
	@Override
	public void update(Observable o, Object arg) {
		myTurtle = (Turtle) o;
		if (myTurtle.shouldReset()) {
			resetCanvas();
		} else {
			clearPreviousTurtle();
			drawTurtle();
		}
	}
	
	/**
	 * Resets Canvas. Deletes all of the Turtle's trails and changes the Turtle back to default.
	 */
	public void resetCanvas() {
		gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
		gcDrawing.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
		drawTurtle();
	}
	
	/**
	 * Clears the previous instance of the Turtle on the canvas.
	 */
	public void clearPreviousTurtle() {
		gc.save(); // saves the current state on stack, including the current transform
		Rotate r = new Rotate(myOldDirection, myOldX + TURTLE_SIZE/2, myOldY + TURTLE_SIZE/2);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
		gc.clearRect(myOldX, myOldY, TURTLE_SIZE, TURTLE_SIZE);
		gc.restore();
	}
	
	/**
	 * Keeps track of the old coordinates after updating the Turtle.
	 */
	public void setOldCoordinates() {
		myOldX = myX;
		myOldY = myY;
	}
	
	/**
	 * Places default turtle on canvas.
	 */
	private void addDefaultTurtle(){
		myX = STARTING_X;
		myY = STARTING_Y;
		turtleImage = new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_TURTLE));
		gc.drawImage(turtleImage, myX, myY, TURTLE_SIZE, TURTLE_SIZE);
		setOldCoordinates();
	}
	
	/**
	 * Sets user-inputed image as the Canvas turtle.
	 * @param file that contains image
	 */
	public void setTurtleImage(File file){
		String filePath = file.getPath();
		String[] splitFilePath = filePath.split(PATH_DELIMITER);
		String fileName = splitFilePath[splitFilePath.length - 1];
		turtleImage = new Image(getClass().getClassLoader().getResourceAsStream(fileName));
		if (myTurtle == null) 
			gc.drawImage(turtleImage, myX, myY, TURTLE_SIZE, TURTLE_SIZE);
		else drawTurtle();
	}
	
	public void setTurtleImage(Image image){
		turtleImage = image;
		if (myTurtle == null) 
			gc.drawImage(turtleImage, myX, myY, TURTLE_SIZE, TURTLE_SIZE);
		else drawTurtle();
	}
	
	/**
	 * Draws the turtle onto canvas based on turtle's X and Y values and its direction.
	 */
	public void drawTurtle() {
		myX = myTurtle.getCurX() + CANVAS_WIDTH/2;
		myY = -(myTurtle.getCurY() - CANVAS_HEIGHT/2);
		gc.save(); // saves the current state on stack, including the current transform
		Rotate r = new Rotate(myTurtle.getDirection(), myX + TURTLE_SIZE/2, myY + TURTLE_SIZE/2);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
		if (myTurtle.showing()) {
			gc.drawImage(turtleImage, myX, myY, TURTLE_SIZE, TURTLE_SIZE);
		}
		if (!myTurtle.isPenUp()) {
			gcDrawing.fillOval(myX + TURTLE_SIZE/2, myY + TURTLE_SIZE/2, 3, 3);
		}
		gc.restore();
		setOldCoordinates();
		myOldDirection = myTurtle.getDirection();
	}
	
	/**
	 * @return GraphicsContext for Canvas Background
	 */
	public GraphicsContext getBackgroundGraphicsContext(){
		return gcBackground;
	}
	
	/**
	 * Sets Pen color based on User preference.
	 * @param Color that user chose.
	 */
	protected void setPenColor(Color c) {
		gcDrawing.setFill(c);
	}
	
	public int getWidth(){
		return CANVAS_WIDTH;
	}
	
	public int getHeight(){
		return CANVAS_HEIGHT;
	}
	
	public String getCoordinateString(){
		return Math.round(myTurtle.getCurX()) + "," + Math.round(myTurtle.getCurY());
	}
	
	public String getHeadingString(){
		return "" + myOldDirection%360;
	}
	
	public boolean getPenDownStatus(){
		return !myTurtle.isPenUp();
	}

}
