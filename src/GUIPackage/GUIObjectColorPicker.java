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
	protected String pickerLabel;
	protected GUICanvas canvas;
	
	public GUIObjectColorPicker(GUICanvas canvas, String pickerLabel) {
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
}
