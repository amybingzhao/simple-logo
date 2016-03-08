package guipackage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import model.Turtle;


/**
 * Returns one Node that contains the Turtle Canvas and two ColorPicker objects
 * (for background and pen)
 *
 * @author AnnieTang
 */

public class GUICanvas implements Observer{
	private static final String DOTTED_LINE = "Dotted Line";
	private static final String DASHED_LINE = "Dashed Line";
	private static final String SOLID_LINE = "Solid Line";
	private static final int DEFAULT_PEN_SIZE = 3;
	private static final Color DEFAULT_PEN_COLOR = Color.BLACK;
	private static final Color DEFAULT_BACKGROUND_COLOR = Color.BISQUE;
	private static final int TURTLE_SIZE = 20;
	private static final int CANVAS_WIDTH = 500;
	private static final int CANVAS_HEIGHT = 500;
	private static final int STARTING_X = CANVAS_WIDTH/2 - TURTLE_SIZE/2;
	private static final int STARTING_Y = CANVAS_HEIGHT/2 - TURTLE_SIZE/2;	
	private static final String DEFAULT_TURTLE = "turtle_outline.png";
	private double myOldDirection;
	private Canvas canvasBackground;
	private Pane myCanvasRoot;
	private GraphicsContext gcBackground;
	private GraphicsContext gc;
	private Map<Turtle, List<GraphicsContext>> myTurtles;
	private List<Double[]> turtleParameters;
	private GUIObjectComboBoxColor myBackgroundPalette;
	private GUIObjectComboBoxColor myPenPalette;
	private GUIObjectComboBoxImages myImagePalette;
	private ResourceBundle myResources;
	
	private double myPenSize;
	private String penType;
	private int penCounter;
	private int myPenColorIndex;
	private String myPenRGB;
	private Color myPenColor;
	
	private String myBackgroundRGB;
	
	private Image turtleImage;
	private String turtleImageName;
	private int myTurtleShapeIndex;
	
	private HBox hboxToReturn;
	private VBox vboxToRight;
	
	public GUICanvas(ResourceBundle myResources) {
		this.myResources = myResources;
	}
	
	
	public void init() {
		myTurtles = new HashMap<Turtle, List<GraphicsContext>>();
		turtleParameters = new ArrayList<Double[]>();
		canvasBackground = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		gcBackground = canvasBackground.getGraphicsContext2D();
		gcBackground.setFill(DEFAULT_BACKGROUND_COLOR);
		gcBackground.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
		addDefaultTurtles();
		myCanvasRoot = new Pane(canvasBackground);
		hboxToReturn = new HBox();
		vboxToRight = new VBox();
	}
	
	/**
	 * Creates the Canvas Node to be displayed.
	 * @return Canvas Node
	 */
	public Node createNode() {
		myBackgroundPalette = new GUIObjectComboBoxColorB(this, myResources, myResources.getString("BackgroundColorPalettePromptText"));
		myPenPalette = new GUIObjectComboBoxColorP(this, myResources, myResources.getString("PenColorPalettePromptText"));
		myImagePalette = new GUIObjectComboBoxImages(this, myResources, myResources.getString("ImageComboBoxPromptText"));
		vboxToRight.getChildren().addAll(myBackgroundPalette.createNode(), myPenPalette.createNode(), myImagePalette.createNode());
		hboxToReturn.getChildren().addAll(myCanvasRoot, vboxToRight);
		setPaletteProperties();
		return hboxToReturn;
	}
	/**
	 * Sets default palette properties, such as pen settings, background color, and turtle image.
	 */
	public void setPaletteProperties(){
		myPenSize = DEFAULT_PEN_SIZE;
		penCounter = 0;
		penType = SOLID_LINE;
		myPenColorIndex = 0;
		myPenRGB = DEFAULT_PEN_COLOR.getRed() + " " + DEFAULT_PEN_COLOR.getGreen() + " " + DEFAULT_PEN_COLOR.getBlue();
		myPenColor = DEFAULT_PEN_COLOR;
		myBackgroundRGB = DEFAULT_BACKGROUND_COLOR.getRed() + " " + DEFAULT_BACKGROUND_COLOR.getGreen() + " " + DEFAULT_BACKGROUND_COLOR.getBlue();
		turtleImageName = DEFAULT_TURTLE;
		myTurtleShapeIndex = getTurtleIndex(turtleImageName);
	}
	
	/**
	 * returns index in palette of given turtle image name.
	 * @return
	 */
	public int getTurtleIndex(String imageName){
		List<String> palette = myImagePalette.getPalette();
		for(String turtleName:palette){
			if(turtleName.equals(imageName)){
				return palette.indexOf(turtleName);
			}
		}
		return -1;
	}
	
	public void addNodeToCanvasRight(Node nodeToAdd){
		vboxToRight.getChildren().add(nodeToAdd);
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
			addTurtleToMap(turtle);
			clearPreviousTurtle(turtle);
			drawTurtle(turtle);
		}
	}
	
	/**
	 * Resets Canvas. Deletes all of the Turtle's trails and changes the Turtle back to default.
	 */
	public void resetCanvas(Turtle turtle) {
		myTurtles.get(turtle).get(0).clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
		myTurtles.get(turtle).get(1).clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
		drawTurtle(turtle);
		turtle.doneResetting();
	}
	
	/**
	 * Keeps track of the old coordinates after updating the Turtle.
	 */
	public void setOldCoordinates(Turtle turtle, double x, double y, double direction) {
		Double[] coordinates = new Double[3];
		coordinates[0] = x;
		coordinates[1] = y;
		coordinates[2] = direction;
		if (turtleParameters.size() < turtle.getID() + 1)
			turtleParameters.add((int) turtle.getID(), coordinates);
		else turtleParameters.set((int) turtle.getID(), coordinates);
	}
	
	/**
	 * Places default turtle on canvas.
	 */
	private void addDefaultTurtles(){
		turtleImage = new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_TURTLE));
	}
	
	private void addTurtleToMap(Turtle turtle){
		if (!myTurtles.containsKey(turtle)) {
			Canvas turtleCanvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
			Canvas drawingCanvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
			GraphicsContext drawingGC = drawingCanvas.getGraphicsContext2D();
			drawingGC.setFill(myPenColor);
			myCanvasRoot.getChildren().addAll(turtleCanvas, drawingCanvas);
			myTurtles.put(turtle, new ArrayList<GraphicsContext>(
					Arrays.asList(turtleCanvas.getGraphicsContext2D(), drawingGC)));
			int myX = STARTING_X;
			int myY = STARTING_Y;
			setOldCoordinates(turtle, myX, myY, 0);
		}
	}
	
	/**
	 * Clears the previous instance of the Turtle on the canvas.
	 */
	public void clearPreviousTurtle(Turtle turtle) {
		GraphicsContext gc = myTurtles.get(turtle).get(0);
		double myOldX = turtleParameters.get((int) turtle.getID())[0].doubleValue();
		double myOldY = turtleParameters.get((int) turtle.getID())[1].doubleValue();
		double myOldDirection = turtleParameters.get((int) turtle.getID())[2].doubleValue();
		gc.save(); // saves the current state on stack, including the current transform
		Rotate r = new Rotate(myOldDirection, myOldX + TURTLE_SIZE/2, myOldY + TURTLE_SIZE/2);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
		gc.clearRect(myOldX, myOldY, TURTLE_SIZE, TURTLE_SIZE);
		gc.restore();
	}

	/**
	 * Draws the turtle onto canvas based on turtle's X and Y values and its direction.
	 */
	public void drawTurtle(Turtle turtle) {
		GraphicsContext gc = myTurtles.get(turtle).get(0);
		GraphicsContext gcDrawing = myTurtles.get(turtle).get(1);
		double myX = turtle.getCurX() + CANVAS_WIDTH/2 - TURTLE_SIZE/2;
		double myY = -(turtle.getCurY() - CANVAS_HEIGHT/2 + TURTLE_SIZE/2);
		gc.save(); // saves the current state on stack, including the current transform
		Rotate r = new Rotate(turtle.getDirection(), myX + TURTLE_SIZE/2, myY + TURTLE_SIZE/2);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
		if (turtle.showing()) {
			gc.drawImage(turtleImage, myX, myY, TURTLE_SIZE, TURTLE_SIZE);
		}
		if (!turtle.isPenUp()) {
			drawLine(gcDrawing, myX, myY);
		}
		gc.restore();
		setOldCoordinates(turtle, myX, myY, turtle.getDirection());
	}
	
	private void drawLine(GraphicsContext gcDrawing, double myX, double myY) {
		int scaledPen = (int) myPenSize * 100;
		switch (penType){
			case SOLID_LINE: {
				drawOval(gcDrawing, myX, myY);
			}
			case DASHED_LINE: {
				if (penCounter < scaledPen / 2) {
					drawOval(gcDrawing, myX, myY);
				} else if (penCounter == scaledPen) {
					penCounter = 0;
				}
				penCounter++;
			}
			case DOTTED_LINE: {
				if (penCounter == scaledPen / 2) {
					drawOval(gcDrawing, myX, myY);
				} else if (penCounter == scaledPen) {
					drawOval(gcDrawing, myX, myY);
					penCounter = 0;
				}
				penCounter++;
			}
		}
	}
	
	private void drawOval(GraphicsContext gcDrawing, double myX, double myY) {
		gcDrawing.fillOval(myX + TURTLE_SIZE/2 - myPenSize/2, myY + TURTLE_SIZE/2 - myPenSize/2,
				myPenSize, myPenSize);
	}
	
	protected void setPenType(String type) {
		penType = type;
	}
	
	/**
	 * @return GraphicsContext for Canvas Background
	 */
	public GraphicsContext getBackgroundGraphicsContext(){
		return gcBackground;
	}
	
	/**
	 * Sets Pen color based on index within palette.
	 * @param index of color in palette.
	 */
	public void setPenColor(int index){
		myPenColorIndex = index;
		List<String> currentPalette = myPenPalette.getPalette();
		String[] rgb = currentPalette.get(index).split(" ");
		Color col = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
		setPenColor(col, currentPalette.get(index));
	}
	
	/**
	 * Sets Pen color based on User preference.
	 * @param Color that user chose.
	 */
	public void setPenColor(Color c, String penColorName) {
		myPenColor = c;
		myPenRGB = penColorName;
		for(List<GraphicsContext> lst: myTurtles.values()){
			if (lst != null){
				GraphicsContext gcPen = lst.get(1);
				gcPen.setFill(c);
			}
		}
	}
	/**
	 * returns current pen color as space separated RGB
	 * @return
	 */
	public String getPenColor() {
		return myPenRGB;
	}
	
	public int getPenColorIndex() {
		return myPenColorIndex;
	}
	
	/**
	 * Sets background color based on index within palette.
	 * @param index of color in palette.
	 */
	public void setBackgroundColor(int index) {
		List<String> currentPalette = myBackgroundPalette.getPalette();
		String[] rgb = currentPalette.get(index).split(" ");
		Color col = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
		setBackgroundColor(col, currentPalette.get(index));
	}
	
	/**
	 * Sets background color based on User preference.
	 * @param Color that user chose.
	 */
	public void setBackgroundColor(Color col, String backgroundColorName){
		myBackgroundRGB = backgroundColorName;
		gcBackground.setFill(col);
		gcBackground.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
	}
	
	/**
	 * Returns current background color of canvas.
	 */
	public String getBackgroundColor(){
		return myBackgroundRGB;
	}
	
	/**
	 * Update both pen and background color palette at given index to given RGB color.
	 * @param Space separated string of RGB values
	 * @param index of color in palette that user wants to change
	 */
	public void setPalette(String RGB, int index){
		myBackgroundPalette.changePalette(RGB, index);
		myPenPalette.changePalette(RGB, index);
	}
	
	/**
	 * Sets Turtle shape/image based on index within palette.
	 * @param index of image in palette.
	 */
	public void setTurtleShape(int index) {
		myTurtleShapeIndex = index;
		List<String> currentPalette = myImagePalette.getPalette();
		String imageName = currentPalette.get(index);
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(imageName));
		setTurtleImage(image, imageName);
	}
	
	/**
	 * Sets user-inputed image as the Canvas turtle.
	 * @param Image
	 */
	public void setTurtleImage(Image image, String imageName){
		turtleImage = image;
		turtleImageName = imageName;
		for(Turtle key: myTurtles.keySet()){
			if (key == null){
				gc.drawImage(turtleImage, STARTING_X, STARTING_Y, TURTLE_SIZE, TURTLE_SIZE);
			}
			else drawTurtle(key);
		}
	}
	/**
	 * returns current turtle image filename
	 * @return
	 */
	public String getTurtleImageName(){
		return turtleImageName;
	}
	
	/**
	 * Returns current index of shape/image of turtle;
	 */
	public int getTurtleShapeIndex() {
		return myTurtleShapeIndex;
	}
		
	public void setPenSize(double size) {
		myPenSize = size;
	}
	
	public void setPen(String penUp) {
		for (Turtle t: myTurtles.keySet()) {
			if (t.isActive() && penUp.equals(myResources.getString("PenUp"))) {
				t.liftPenUp();
			} else if (t.isActive() && penUp.equals(myResources.getString("PenDown"))){
				t.putPenDown();
			}
		}
	}
	
//	public String getCoordinateString(){
//		return Math.round(turtle.getCurX()) + "," + Math.round(turtle.getCurY());
//	}
	
	public String getHeadingString(){
		return "" + myOldDirection%360;
	}
	
//	public boolean getPenDownStatus(){
//		return !turtle.isPenUp();
//	}
	
	public int getWidth(){
		return CANVAS_WIDTH;
	}
	
	public int getHeight(){
		return CANVAS_HEIGHT;
	}

}