package guipackage;

import java.util.List;
import java.util.ResourceBundle;

import controller.Controller;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

/**
 * Abstract class to allow ComboBoxes that set some color value of the canvas.
 * @author AnnieTang
 *
 */
abstract class GUIObjectComboBoxColor extends GUIObjectComboBox{
	protected List<String> palette;
	
	public GUIObjectComboBoxColor(GUICanvas canvas, ResourceBundle myResources,
			String promptText) {
		super(canvas, myResources, promptText);
		fillDefaultPalette();
	}

	protected abstract void fillDefaultPalette();

	@Override
	protected void setButtonAction() {
		comboButton.setOnAction(event -> {
			String[] rgb = comboBox.getValue().split(" ");
       	 	Color col = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
			setCanvasValues(col);
			});
	}
	
	protected abstract void setCanvasValues(Color col);

	@Override
	protected void setCellFactory() {
		 comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
		     @Override public ListCell<String> call(ListView<String> p) {
		         return new ListCell<String>() {
		             private final Rectangle rectangle;
		             { 
		                 rectangle = new Rectangle(20, 20);
		             }
		             
		             @Override protected void updateItem(String item, boolean empty) {
		                 super.updateItem(item, empty);
		                 if (item == null || empty) {
		                     setGraphic(null);
		                 } else {
		                	 HBox hbox = new HBox();
		                	 Label colorRGB = new Label(item);
		                	 String[] rgb = item.split(" ");
		                	 Color col = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
		                     rectangle.setFill(col);
		                     hbox.getChildren().addAll(rectangle, colorRGB);
		                     setGraphic(hbox);
		                 }
		            }
		       };
		   }
		});
	}

	@Override
	protected List<String> optionsList() {
		return palette;
	}
	
	public void changePalette(String RGB, int index) {
		List<String> currentPalette = comboBox.getItems();
		if(index<currentPalette.size()){
			currentPalette.set(index, RGB);
		}
		palette = currentPalette;
		updateNode();
	}
	
	public List<String> getPalette(){
		return palette;
	}

}
