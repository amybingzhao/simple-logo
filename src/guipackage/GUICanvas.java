package guipackage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

//import javafx.animation.Animation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import model.Turtle;


/**
 * Returns one Node that contains the Turtle Canvas and its set-able components.
 * @author AnnieTang, DavidYang
 */

public class GUICanvas implements Observer{
	private static final String DOTTED_LINE = "Dotted Line";
	private static final String DASHED_LINE = "Dashed Line";
	private static final String SOLID_LINE = "Solid Line";
	private static final int TURTLE_SIZE = 20;
	private static final int CANVAS_WIDTH = 500;
	private static final int CANVAS_HEIGHT = 500;
	private static final int STARTING_X = CANVAS_WIDTH/2 - TURTLE_SIZE/2;
	private static final int STARTING_Y = CANVAS_HEIGHT/2 - TURTLE_SIZE/2;	
	private static final int PEN_SCALE = 100;
	private static final int DEFAULT = 0;
	private static final int MAX_COORDINATE = 500;
	private static final int MIN_COORDINATE = 0;
	private Canvas canvasStamps;
	private Pane myCanvasRoot;
	private GraphicsContext gcStamps;
	private Map<Turtle, List<GraphicsContext>> myTurtles;
	private List<Double[]> turtleParameters;	
	private ResourceBundle myResources;
	private GUICanvasPen myPen;
	private GUICanvasRight canvasRight;
	private Group root;
	private GUICanvasTurtle myTurtleImageView;
	private GUICanvasBackground myBackgroundCanvas;
	
	public GUICanvas(ResourceBundle myResources) {
		this.myResources = myResources;
		this.canvasRight = (GUICanvasRight) canvasRight;
		myTurtles = new HashMap<>();
		turtleParameters = new ArrayList<>();
		canvasStamps = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		gcStamps = canvasStamps.getGraphicsContext2D();
		myPen = new GUICanvasPen();
		myBackgroundCanvas = new GUICanvasBackground(CANVAS_WIDTH, CANVAS_HEIGHT);
		myCanvasRoot = new Pane(myBackgroundCanvas.getCanvas(), canvasStamps);
		root = new Group(myCanvasRoot);
		myTurtleImageView = new GUICanvasTurtle(root);
	}
	
	/**
	 * Creates the Canvas Node to be displayed.
	 * @return Canvas Node
	 */
	public Node createNode() {
		return root;
	}
	/**
	 * Adds object to position right of the canvas.
	 * @param rightOfCanvas
	 */
	public void setRightCanvas(GUICanvasRight rightOfCanvas){
		canvasRight = rightOfCanvas;
		myPen.setMyPenPalette(canvasRight.getPenPalette());
		myBackgroundCanvas.setMyBackgroundPalette(canvasRight.getBackgroundPalette());
		myTurtleImageView.setMyImagePalette(canvasRight.getImagePalette());
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
	}
	
	
	/**
	 * Resets Canvas. Deletes all of the Turtle's trails and changes the Turtle back to default.
	 */
	private void resetCanvas(Turtle turtle) {
		for(Turtle key: myTurtles.keySet()){
			List<GraphicsContext> lst = myTurtles.get(key);
			lst.get(0).clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
			lst.get(1).clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
			drawTurtle(key);
			myTurtleImageView.removeTurtleImageView(turtle);
			key.doneResetting();
		}
	}
	
	/**
	 * Keeps track of the old coordinates after updating the Turtle.
	 */
	private void setOldCoordinates(Turtle turtle, double x, double y, double direction) {
		Double[] coordinates = new Double[3];
		coordinates[0] = x;
		coordinates[1] = y;
		coordinates[2] = direction;
		if (turtleParameters.size() <= turtle.getID())
			turtleParameters.add((int) turtle.getID() - 1, coordinates);
		else turtleParameters.set((int) turtle.getID() - 1, coordinates);
	}
	
	protected void updateTurtleImageView(){
		for(Turtle turtle: myTurtles.keySet()){
				drawTurtle(turtle);
		}
	}
	
	private void updatePenColors(){
		for(List<GraphicsContext> lst: myTurtles.values()){
		if (lst != null){
			GraphicsContext gcPen = lst.get(1);
			gcPen.setFill(myPen.getMyPenColor());
		}
	}
	}
	
	private void addTurtleToMap(Turtle turtle){
		if (!myTurtles.containsKey(turtle)) {
			Canvas turtleCanvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
			Canvas drawingCanvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
			GraphicsContext drawingGC = drawingCanvas.getGraphicsContext2D();
			drawingGC.setFill(myPen.getMyPenColor());
			myCanvasRoot.getChildren().addAll(turtleCanvas, drawingCanvas);
			myTurtles.put(turtle, new ArrayList<GraphicsContext>(
					Arrays.asList(turtleCanvas.getGraphicsContext2D(), drawingGC)));
			int myX = STARTING_X;
			int myY = STARTING_Y;
			setOldCoordinates(turtle, myX, myY, DEFAULT);
			myTurtleImageView.createImageViewForTurtle(turtle, toroidalBounds(myX), toroidalBounds(myY), canvasRight);
		}
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
		Rotate r = new Rotate(myOldDirection, myOldX + TURTLE_SIZE/2, myOldY + TURTLE_SIZE/2);
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
		double myX = toroidalBounds(turtle.getCurX() + CANVAS_WIDTH/2 - TURTLE_SIZE/2);
		double myY = toroidalBounds(-(turtle.getCurY() - CANVAS_HEIGHT/2 + TURTLE_SIZE/2));
		gc.save(); // saves the current state on stack, including the current transform
		Rotate r = new Rotate(turtle.getDirection(), myX + TURTLE_SIZE/2, myY + TURTLE_SIZE/2);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
		if (turtle.showing()) {
			ImageView currentImageView = turtle.getImageView();
			myTurtleImageView.updateImageView(currentImageView, myX, myY, turtle.getDirection(), myTurtleImageView.getTurtleShape());
		}
		if (!turtle.isPenUp()) {
			drawLine(gcDrawing, myX, myY);
		}
		gc.restore();
		setOldCoordinates(turtle, myX, myY, turtle.getDirection());
	}
	
	private double toroidalBounds(double coordinate) {
		if (coordinate > MAX_COORDINATE || coordinate < MIN_COORDINATE) {
			coordinate = coordinate - MAX_COORDINATE * Math.floor(coordinate / MAX_COORDINATE);
		}
		return coordinate;
	}
	
	private void drawLine(GraphicsContext gcDrawing, double myX, double myY) {
		int scaledPen = (int) myPen.getMyPenSize() * PEN_SCALE;
		switch (myPen.getMyPenType()){
			case SOLID_LINE: {
				drawOval(gcDrawing, myX, myY);
			}
			case DASHED_LINE: {
				if (myPen.getMyPenCounter() < scaledPen / 2) {
					drawOval(gcDrawing, myX, myY);
				} else if (myPen.getMyPenCounter() == scaledPen) {
					myPen.resetPenCounter();;
				}
				myPen.incrementMyPenCounter();;
			}
			case DOTTED_LINE: {
				if (myPen.getMyPenCounter() == scaledPen / 2) {
					drawOval(gcDrawing, myX, myY);
				} else if (myPen.getMyPenCounter()== scaledPen) {
					drawOval(gcDrawing, myX, myY);
					myPen.resetPenCounter();
				}
				myPen.incrementMyPenCounter();;
			}
		}
	}

	private void drawOval(GraphicsContext gcDrawing, double myX, double myY) {
		long penSize = Math.round(myPen.getMyPenSize());
		gcDrawing.fillOval(myX + TURTLE_SIZE/2 - penSize/2, myY + TURTLE_SIZE/2 - penSize/2,
				penSize, penSize);
	}
	
	public double drawStamps() {
		for (Turtle turtle: myTurtles.keySet()) {
			if (turtle.isActive()) {
				gcStamps.drawImage(myTurtleImageView.getTurtleShape(), toroidalBounds(turtle.getCurX() + STARTING_X),
						toroidalBounds(-turtle.getCurY() + STARTING_Y), TURTLE_SIZE, TURTLE_SIZE);
			}
		}
		return myTurtleImageView.getTurtleShapeIndex();
	}
	
	public void clearStamps() {
		clearGraphicsContext(gcStamps);
	}
	
	private void clearGraphicsContext(GraphicsContext gc) {
		gc.clearRect(DEFAULT, DEFAULT, CANVAS_WIDTH, CANVAS_HEIGHT);
	}
	
	/**
	 * Update both pen and background color palette at given index to given RGB color.
	 * @param Space separated string of RGB values
	 * @param index of color in palette that user wants to change
	 */
	public void setPalette(String RGB, int index){
		canvasRight.changePalettes(RGB, index);
	}
	
	/**
	 * returns current Pen object
	 */
	public GUICanvasPen getPen() {
		return myPen;
	}
	
	public GUICanvasBackground getBackgroundCanvas(){
		return myBackgroundCanvas;
	}
	
	public GUICanvasTurtle getTurtleImageView(){
		return myTurtleImageView;
	}

	protected void setTurtlePenStatus(String penUp) {
		for (Turtle t: myTurtles.keySet()) {
			if (t.isActive() && penUp.equals(myResources.getString("PenUp"))) {
				t.setPenUp(true);
			} else if (t.isActive() && penUp.equals(myResources.getString("PenDown"))){
				t.setPenUp(false);
			}
		}
	}
}