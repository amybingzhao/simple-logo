package guipackage;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * Color picker for the canvas.
 * @author
 *
 */
public class GUIObjectColorPickerBackground extends GUIObjectColorPicker {

	public GUIObjectColorPickerBackground(GUICanvas canvas, String pickerLabel) {
		super(canvas, pickerLabel);
	}

	/**
	 * Sets canvas's color to chosen color.
	 */
	@Override
	protected void handleEvent(ColorPicker colorPicker) {
		canvas.getBackgroundGraphicsContext().setFill(colorPicker.getValue());
		canvas.getBackgroundGraphicsContext().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	/**
	 * Sets starting color to BISQUE.
	 */
	@Override
	protected Color getStartColor() {
		return Color.BISQUE;
	}

}
