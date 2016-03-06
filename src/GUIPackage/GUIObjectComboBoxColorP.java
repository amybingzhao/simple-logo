package GUIPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import Controller.Controller;
import javafx.scene.paint.Color;

/**
 * Editable color palette for pen color.
 * @author AnnieTang
 *
 */
public class GUIObjectComboBoxColorP extends GUIObjectComboBoxColor {

	public GUIObjectComboBoxColorP(GUICanvas canvas, ResourceBundle myResources, Controller myController,
			String promptText, GUICommandLine myCommandLine) {
		super(canvas, myResources, myController, promptText, myCommandLine);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void fillDefaultPalette() {
		List<String> defaultColors = new ArrayList<String>(Arrays.asList(myResources.getString("DefaultPenColors").split(",")));
		defaultPalette = defaultColors;
	}

	@Override
	protected void setCanvasValues(Color col) {
		canvas.setPenColor(col);
	}
	
}
