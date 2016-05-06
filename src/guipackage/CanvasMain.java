/**
 * Modified for VOOGASalad addition
 */
package guipackage;
import java.util.*;

import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;
import javafx.scene.transform.Rotate;
import model.Turtle;

/**
 * Returns one Node that contains the Turtle Canvas and its set-able components.
 * made partial refactorings to David Yang's work during SLogo, further refactored since SLogo for VOOGASalad addition 
 * @author refactored by Annie Tang 
 */

public class CanvasMain implements Observer{
	
	private static final int CANVAS_WIDTH = 500;
	private static final int CANVAS_HEIGHT = 500;
	private static final int TURTLE_SIZE = 20;
	private static final int CENTER_FACTOR = TURTLE_SIZE/2;
	private static final int CANVAS_X_TRANSFORM = CANVAS_WIDTH/2;
	private static final int CANVAS_Y_TRANSFORM = CANVAS_HEIGHT/2;
	private static final int STARTING_X = CANVAS_X_TRANSFORM - CENTER_FACTOR;
	private static final int STARTING_Y = CANVAS_Y_TRANSFORM - CENTER_FACTOR;	
	private static final int ZERO = 0;
	private static final int MAX_COORDINATE = 500;
	private static final int MIN_COORDINATE = 0;
	
	private Map<Turtle, List<GraphicsContext>> myTurtles;
	private List<Double[]> turtleParameters;	
	private Canvas myCanvas;
	private Pane myCanvasPane;
	private GraphicsContext myGC;
	private ResourceBundle myResources;
	private CanvasPen myPen;
	private CanvasRight myRight;
	private Group myRoot;
	private CanvasImageManager myImageManager;
	private CanvasAnimation myAnimation;
	private BorderPane myBorderPane;
	private CanvasBackground myBackground;
	private CanvasTurtleViewer canvasTurtleViewer;
	
	public CanvasMain(ResourceBundle myResources) {
		this.myResources = myResources;		
		initializeEnvironment();
	}
	
	private void initializeEnvironment(){
		myTurtles = new HashMap<>();
		turtleParameters = new ArrayList<>();
		myAnimation = new CanvasAnimation();
		canvasTurtleViewer = new CanvasTurtleViewer(this, myResources);
		myBorderPane = new BorderPane(); 
		setLeftPane();
		myImageManager = new CanvasImageManager(myRoot, this);
		myPen = new CanvasPen();
		setRightPane();
	}
	
	private void setLeftPane(){
		myCanvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		myGC = myCanvas.getGraphicsContext2D();
		myBackground = new CanvasBackground(CANVAS_WIDTH, CANVAS_HEIGHT);
		myCanvasPane = new Pane(myBackground.getCanvas(), myCanvas);
		myRoot = new Group(myCanvasPane);
		myBorderPane.setLeft(myRoot);
	}
	
	private void setRightPane(){
		myRight = new CanvasRight(myResources,this);
		myPen.setMyPenPalette(myRight.getPenPalette());
		myBackground.setMyBackgroundPalette(myRight.getBackgroundPalette());
		myImageManager.setMyImagePalette(myRight.getImagePalette());
		myBorderPane.setRight(myRight.createNode());
	}
	
	public void setCenterPane(){
		myBorderPane.setCenter(canvasTurtleViewer.createNode());
	}
	
	/**
	 * Creates the BorderPane to be displayed.
	 * @return BorderPane
	 */
	public Node getNode() {
		return myBorderPane;
	}
	
	/**
	 * Updates the Canvas when the Turtle is updated.
	 */
	@Override
	public void update(Observable o, Object args) {
		Turtle turtle = (Turtle) o;
		if (turtle.shouldReset()) {
			resetCanvas(turtle);
		} else {
			updatePenColors();
			addTurtleToMap(turtle); 
			clearPreviousTurtle(turtle);
			drawTurtle(turtle);
		}
		setCenterPane();
	}
	
	/**
	 * Resets Canvas. Deletes all of the Turtle's trails and changes the Turtle back to default position.
	 */
	private void resetCanvas(Turtle turtle) {
		for(Turtle key: myTurtles.keySet()){
			List<GraphicsContext> lst = myTurtles.get(key);
			lst.get(0).clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
			lst.get(1).clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
			drawTurtle(key);
			myImageManager.updateImageView(turtle, STARTING_X, STARTING_Y, ZERO, turtle.getImage());
			key.doneResetting();
		}
	}
	
	/**
	 * Updates image for each turtle on the canvas.
	 */
	protected void updateTurtleImageView(){
		for(Turtle turtle: myTurtles.keySet()){
				drawTurtle(turtle);
		}
	}
	/**
	 * Updates pen color for each turtle on the canvas.
	 */
	private void updatePenColors(){
		for(List<GraphicsContext> lst: myTurtles.values()){
			if (lst != null){
				GraphicsContext gcPen = lst.get(1);
				gcPen.setFill(myPen.getMyPenColor());
			}
		}
	}
	
	/**
	 * Adds each new turtle to the map when created.
	 * @param turtle
	 */
	private void addTurtleToMap(Turtle turtle){
		if (!myTurtles.containsKey(turtle)) {
			Canvas turtleCanvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
			Canvas drawingCanvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
			GraphicsContext drawingGC = drawingCanvas.getGraphicsContext2D();
			drawingGC.setFill(myPen.getMyPenColor());
			myCanvasPane.getChildren().addAll(turtleCanvas, drawingCanvas);
			myTurtles.put(turtle, new ArrayList<GraphicsContext>(
					Arrays.asList(turtleCanvas.getGraphicsContext2D(), drawingGC)));
			int myX = STARTING_X;
			int myY = STARTING_Y;
			setOldCoordinates(turtle, myX, myY, ZERO);
			myImageManager.createImageViewForTurtle(turtle, getToroidal(myX), getToroidal(myY), myRight);
		}
	}
	
	/**
	 * Keeps track of the old coordinates after updating the Turtle.
	 */
	private void setOldCoordinates(Turtle turtle, double x, double y, double direction) {
		Double[] coordinates = {x, y, direction};
		if (turtleParameters.size() <= turtle.getID())
			turtleParameters.add((int) turtle.getID() - 1, coordinates);
		else turtleParameters.set((int) turtle.getID() - 1, coordinates);
	}
	
	/**
	 * Clears the previous instance of the Turtle on the canvas.
	 */
	private void clearPreviousTurtle(Turtle turtle) {
		GraphicsContext gc = myTurtles.get(turtle).get(0);
		double myOldX = turtleParameters.get((int) turtle.getID() - 1)[0].doubleValue();
		double myOldY = turtleParameters.get((int) turtle.getID() - 1)[1].doubleValue();
		double myOldDirection = turtleParameters.get((int) turtle.getID() - 1)[2].doubleValue();
		gc.save(); // saves the current state on stack, including the current transform
		Rotate r = new Rotate(myOldDirection, myOldX + CENTER_FACTOR, myOldY + CENTER_FACTOR);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
		gc.clearRect(myOldX, myOldY, TURTLE_SIZE, TURTLE_SIZE);
		gc.restore();
	}

	/**
	 * Draws the turtle onto canvas based on turtle's X and Y values and its direction.
	 */
	private void drawTurtle(Turtle turtle) {
		GraphicsContext gc = myTurtles.get(turtle).get(0);
		GraphicsContext gcDrawing = myTurtles.get(turtle).get(1);
		double myX = getToroidal(turtle.getCurX() + CANVAS_X_TRANSFORM - CENTER_FACTOR);
		double myY = getToroidal(-(turtle.getCurY() - CANVAS_Y_TRANSFORM + CENTER_FACTOR));
		gc.save(); // saves the current state on stack, including the current transform
		Rotate r = new Rotate(turtle.getDirection(), myX + CENTER_FACTOR, myY + CENTER_FACTOR);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
		if (!turtle.isPenUp()) myPen.drawLine(gcDrawing, myX, myY, CENTER_FACTOR);
		if (turtle.showing()) myAnimation.checkForAnimation(turtle, myX, myY, turtleParameters, myImageManager);
		gc.restore();
		setOldCoordinates(turtle, myX, myY, turtle.getDirection());
	}
	
	/**
	 * Converts coordinate to its toroidal coordinate if it is greater than the maximum or less than the minimum coordinate.
	 * @param coordinate
	 * @return
	 */
	private double getToroidal(double coordinate) {
		if (coordinate > MAX_COORDINATE) {
			coordinate = coordinate%MAX_COORDINATE;
		}
		else if(coordinate < MIN_COORDINATE){
			double temp_pos = Math.abs(coordinate);
			double temp_mod = temp_pos%MAX_COORDINATE;
			coordinate = MAX_COORDINATE - temp_mod;
		}
		return coordinate;
	}
	
	/**
	 * Creates stamps for each turtle when the stamp command is called.
	 * @return
	 */
	public double drawStamps() {
		for (Turtle turtle: myTurtles.keySet()) {
			if (turtle.isActive()) {
				myGC.drawImage(turtle.getImage(), getToroidal(turtle.getCurX() + STARTING_X),
						getToroidal(-turtle.getCurY() + STARTING_Y), TURTLE_SIZE, TURTLE_SIZE);
			}
		}
		return myImageManager.getTurtleImageIndex();
	}
	
	/**
	 * Clears the stamps that have previously been created.
	 */
	public void clearStamps() {
		myGC.clearRect(ZERO, ZERO, CANVAS_WIDTH, CANVAS_HEIGHT);
	}
	
	/**
	 * Update both pen and background color palette at given index to given RGB color.
	 * @param Space separated string of RGB values
	 * @param index of color in palette that user wants to change
	 */
	public void setPalette(String RGB, int index){
		myRight.setPalettes(RGB, index);
	}
	
	/**
	 * returns current Pen object
	 */
	public CanvasPen getPen() {
		return myPen;
	}
	
	public CanvasBackground getCanvasBackground(){
		return myBackground;
	}
	
	public CanvasImageManager getImageManager(){
		return myImageManager;
	}
	
	protected CanvasAnimation getAnimation(){
		return myAnimation;
	}
	/**
	 * Set pen state (up/down) of every turtle on the canvas. 
	 * @param penState
	 */
	protected void setTurtlePenStatus(String penState) {
		for (Turtle t: myTurtles.keySet()) {
			if (t.isActive() && penState.equals(myResources.getString("PenUp"))) t.setPenUp(true);
			else if (t.isActive() && penState.equals(myResources.getString("PenDown"))) t.setPenUp(false);
		}
	}
	
	public Map<Turtle, List<GraphicsContext>> getMyTurtles(){
		return this.myTurtles;
	}
}