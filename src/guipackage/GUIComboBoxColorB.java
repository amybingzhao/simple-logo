package guipackage;

import java.util.ResourceBundle;

import javafx.scene.paint.Color;
/**
 * Editable color palette for background color.
 * @author AnnieTang
 *
 */
public class GUIComboBoxColorB extends GUIComboBoxColor {	
	
	public GUIComboBoxColorB(GUICanvas canvas, ResourceBundle myResources,
			String promptText, String paletteSource) {
		super(canvas, myResources, promptText, paletteSource);
	}

	@Override
	protected void setCanvasValues(Color col) {
		canvas.setBackgroundColor(col, comboBox.getValue());
	}
	
}
