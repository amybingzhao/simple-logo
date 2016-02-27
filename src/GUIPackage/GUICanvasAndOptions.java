package GUIPackage;
import java.util.ResourceBundle;

import Controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
/**
 * Returns one Node that contains the Turtle Canvas and two ColorPicker objects
 * (for background and pen)
 * @author AnnieTang
 *
 */
public class GUICanvasAndOptions {
	private static final int SIZE = 300; 
	private Controller contr;
	private int xPos;
	private int yPos;
	private GraphicsContext gc;
	private Canvas canvas;
	private ColorPicker backgroundColorPicker;
	private ColorPicker penColorPicker;
	private VBox entireCanvas;
	private ResourceBundle myResources; 
	
	public GUICanvasAndOptions(Controller contr, ResourceBundle myResources, String xPosString, String yPosString) {
		this.contr = contr;
		this.myResources = myResources;
		this.xPos = Integer.parseInt(myResources.getString(xPosString));
		this.yPos = Integer.parseInt(myResources.getString(yPosString));
		this.entireCanvas = new VBox();
	}

	public Node createNode() {
		canvas = new Canvas(SIZE, SIZE);
		canvas.setLayoutX(xPos);
		canvas.setLayoutX(yPos);
		
		gc = canvas.getGraphicsContext2D();
		
		backgroundColorPicker = new ColorPicker(Color.WHITE);
		backgroundColorPicker.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gc.setFill(backgroundColorPicker.getValue());
			}
        });
		
		penColorPicker = new ColorPicker(Color.WHITE);
		penColorPicker.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gc.setStroke(penColorPicker.getValue());
			}
        });
		
		entireCanvas.getChildren().addAll(backgroundColorPicker, penColorPicker, canvas);
		
		return entireCanvas;
	}

	public void updateNode() {		
		//update turtle stuff using controller ----------------------------------
	}
	
	private void drawPath(){
		
	}
	
	public void setImage(){
		//called from GUIObjectVBox for image upload 
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
}
