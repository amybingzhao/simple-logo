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
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
/**
 * Returns one Node that contains the Turtle Canvas and two ColorPicker objects
 * (for background and pen)
 * @author AnnieTang
 *
 */
public class GUICanvasAndOptions {
	private static final int CANVAS_WIDTH = 500;
	private static final int CANVAS_HEIGHT = 500;
	private Controller contr;
	private int xPos;
	private int yPos;
	private GraphicsContext gc;
	private Canvas canvas;
	private ResourceBundle myResources; 
	
	public GUICanvasAndOptions(Controller myController, ResourceBundle myResources, String xPosString, String yPosString) {
		this.contr = myController;
		this.myResources = myResources;
		this.xPos = Integer.parseInt(myResources.getString(xPosString));
		this.yPos = Integer.parseInt(myResources.getString(yPosString));
	}

	public Node createNode() {
		canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		canvas.setLayoutX(xPos);
		canvas.setLayoutX(yPos);
		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.ALICEBLUE);
		gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);		
		return canvas;
	}

	public void updateNode() {		
		//update turtle stuff using controller ----------------------------------
	}
	
	private void drawPath(){
		
	}
	
	public void setImage(){
		//called from GUIObjectVbox for image upload 
	}

	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setXPos(int val) {
		xPos = val;
	}

	public void setYPos(int val) {
		yPos = val;
	}
	
	public GraphicsContext getGraphicsContext(){
		return gc;
	}
	
	public int getWidth(){
		return CANVAS_WIDTH;
	}
	
	public int getHeight(){
		return CANVAS_HEIGHT;
	}
}
