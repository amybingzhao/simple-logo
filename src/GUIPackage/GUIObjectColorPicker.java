package GUIPackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

abstract class GUIObjectColorPicker implements GUIObject {
	private int xPos;
	private int yPos;
	protected String pickerLabel;
	protected GUICanvasAndOptions canvas;
	
	public GUIObjectColorPicker(GUICanvasAndOptions canvas, String pickerLabel, int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.pickerLabel = pickerLabel;
		this.canvas = canvas; 
	}

	@Override
	public Node createNode() {
		VBox box = new VBox();
        box.setPadding(new Insets(5, 5, 5, 5));          
    	ColorPicker colorPicker = new ColorPicker(Color.WHITE);
		colorPicker.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleEvent(colorPicker);
			}
        });
        
        Label text = new Label(pickerLabel);
        box.getChildren().addAll(text, colorPicker);
        return box;
	}

	abstract void handleEvent(ColorPicker colorPicker);
	
	@Override
	public void updateNode() {
	}

	@Override
	public int getXPos() {
		return xPos;
	}

	@Override
	public int getYPos() {
		return yPos;
	}

	@Override
	public void setXPos(int val) {
		xPos = val;	
	}

	@Override
	public void setYPos(int val) {
		yPos = val;
	}

}
