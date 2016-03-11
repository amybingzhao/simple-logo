package guipackage;

import java.util.ResourceBundle;
import javafx.scene.paint.Color;

/**
 * Editable color palette for pen color.
 * @author AnnieTang
 *
 */
public class GUIComboBoxColorP extends GUIComboBoxColor {

	public GUIComboBoxColorP(GUICanvas canvas, ResourceBundle myResources,
			String promptText, String paletteSource) {
		super(canvas, myResources, promptText, paletteSource);
	}

	@Override
	protected void setCanvasValues(Color col) {
		canvas.getPen().setMyPenColor(col, comboBox.getValue());
	}
	
}
