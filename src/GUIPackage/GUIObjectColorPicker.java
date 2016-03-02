package GUIPackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Creates a ColorPicker that allows user to choose color for something.
 * @author AnnieTang
 */

abstract class GUIObjectColorPicker implements IGUIObject {
	protected String pickerLabel;
	protected GUICanvas canvas;
	
	public GUIObjectColorPicker(GUICanvas canvas, String pickerLabel) {
		this.pickerLabel = pickerLabel;
		this.canvas = canvas; 
	}
	
	/**
	 * Creates Color Picker and returns it as a Node.
	 */
	@Override
	public Node createNode() {
		VBox box = new VBox();
        box.setPadding(new Insets(5, 5, 5, 5));          
    	ColorPicker colorPicker = new ColorPicker(getStartColor());
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
	
	/**
	 * Starting color for the ColorPicker
	 * @return Starting color
	 */
	protected abstract Color getStartColor();
	
	/**
	 * Tells GUI what to do after a color is chosen.
	 * @param colorPicker
	 */
	protected abstract void handleEvent(ColorPicker colorPicker);
	
	/**
	 * Update node method. Never really need to update.
	 */
	@Override
	public void updateNode() {
	}
}
