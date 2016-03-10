package guipackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.paint.Color;
/**
 * Editable color palette for background color.
 * @author AnnieTang
 *
 */
public class GUIComboBoxColorB extends GUIComboBoxColor {	
	
	public GUIComboBoxColorB(GUICanvas canvas, ResourceBundle myResources,
			String promptText) {
		super(canvas, myResources, promptText);
	}

	@Override
	protected void fillDefaultPalette() {
		List<String> defaultColors = new ArrayList<String>(Arrays.asList(myResources.getString("DefaultBackgroundColors").split(",")));
		palette = defaultColors;
	}

	@Override
	protected void setCanvasValues(Color col) {
		canvas.setBackgroundColor(col, comboBox.getValue());
	}
	
}
