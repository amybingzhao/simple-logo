package guipackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import controller.Controller;
import javafx.scene.paint.Color;

/**
 * Editable color palette for pen color.
 * @author AnnieTang
 *
 */
public class GUIObjectComboBoxColorP extends GUIObjectComboBoxColor {

	public GUIObjectComboBoxColorP(GUICanvas canvas, ResourceBundle myResources,
			String promptText) {
		super(canvas, myResources, promptText);
	}

	@Override
	protected void fillDefaultPalette() {
		List<String> defaultColors = new ArrayList<String>(Arrays.asList(myResources.getString("DefaultPenColors").split(",")));
		palette = defaultColors;
	}

	@Override
	protected void setCanvasValues(Color col) {
		canvas.setPenColor(col, comboBox.getValue());
	}
	
}
