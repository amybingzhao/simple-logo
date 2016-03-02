package GUIPackage;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * Sets color for turtle pen.
 * @author
 *
 */
public class GUIObjectColorPickerPen extends GUIObjectColorPicker {

	public GUIObjectColorPickerPen(GUICanvas canvas, String pickerLabel) {
		super(canvas, pickerLabel);
	}
	
	/**
	 * Sets pen color to chosen color once clicked.
	 */
	@Override
	protected void handleEvent(ColorPicker colorPicker) {
		canvas.setPenColor(colorPicker.getValue());
	}

	/**
	 * Sets starting color as Black.
	 */
	@Override
	protected Color getStartColor() {
		return Color.BLACK;
	}

}
