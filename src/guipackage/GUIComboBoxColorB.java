package guipackage;

import java.util.ResourceBundle;

import javafx.scene.paint.Color;
/**
 * Editable color palette for background color.
 * @author AnnieTang
 *
 */
public class GUIComboBoxColorB extends GUIComboBoxColor {	
	
	public GUIComboBoxColorB(CanvasMain canvas, ResourceBundle myResources,
			String promptText, String paletteSource) {
		super(canvas, myResources, promptText, paletteSource);
	}
	
	/**
	 * On comboButton click, canvas background will be set to new color. 
	 */
	@Override
	protected void setCanvasValues(Color col) {
		canvas.getCanvasBackground().setBackgroundColor(col, comboBox.getValue());
	}
}
