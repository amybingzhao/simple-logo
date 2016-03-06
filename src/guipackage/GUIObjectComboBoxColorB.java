package guipackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import controller.Controller;
import javafx.scene.paint.Color;
/**
 * Editable color palette for background color.
 * @author AnnieTang
 *
 */
public class GUIObjectComboBoxColorB extends GUIObjectComboBoxColor {	
	public GUIObjectComboBoxColorB(GUICanvas canvas, ResourceBundle myResources, Controller myController,
			String promptText, GUICommandLine myCommandLine) {
		super(canvas, myResources, myController, promptText, myCommandLine);
	}

	@Override
	protected void fillDefaultPalette() {
		List<String> defaultColors = new ArrayList<String>(Arrays.asList(myResources.getString("DefaultBackgroundColors").split(",")));
		defaultPalette = defaultColors;
	}

	@Override
	protected void setCanvasValues(Color col) {
		canvas.setBackgroundColor(col);
	}
	
}
