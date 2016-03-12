package guipackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Abstract class to allow ComboBoxes that set some color value of the canvas.
 * @author AnnieTang
 *
 */
abstract class GUIComboBoxColor extends GUIComboBox{
	protected List<String> palette;
	
	public GUIComboBoxColor(GUICanvas canvas, ResourceBundle myResources,
			String promptText, String paletteSource) {
		super(canvas, myResources, promptText, paletteSource);
		fillDefaultPalette();
	}

	protected void fillDefaultPalette() {
		List<String> defaultColors = new ArrayList<>(Arrays.asList(paletteSource.split(",")));
		palette = defaultColors;
	}

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
	protected Node getNodeForBox(String item){
		HBox hbox = new HBox();
		String[] rgb = item.split(" ");
	   	Color col = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
	   	Rectangle rectangle = new Rectangle(20, 20);
	   	rectangle.setFill(col);
	   	hbox.getChildren().addAll(new Label(options.indexOf(item) + " "), rectangle); 
	   	return hbox;
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
}
