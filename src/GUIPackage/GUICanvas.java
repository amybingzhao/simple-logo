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
public class GUICanvas {
	private static final int CANVAS_WIDTH = 500;
	private static final int CANVAS_HEIGHT = 600;
	private Controller myController;
	private GraphicsContext gc;
	private Canvas canvas;
	private ResourceBundle myResources; 
	
	public GUICanvas(Controller myController, ResourceBundle myResources) {
		this.myController = myController;
		this.myResources = myResources;
	}

	public Node createNode() {
		canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BISQUE);
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
