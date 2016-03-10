package guipackage;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * Sets color for turtle pen.
 * @author AnnieTang
 *
 */
public class GUIColorPickerPen extends GUIColorPicker {

	public GUIColorPickerPen(GUICanvas canvas, String pickerLabel) {
		super(canvas, pickerLabel);
	}
	
	/**
	 * Sets pen color to chosen color once clicked.
	 */
	@Override
	protected void handleEvent(ColorPicker colorPicker) {
		String rgb = colorPicker.getValue().getRed() + " " + colorPicker.getValue().getGreen() + " " + colorPicker.getValue().getBlue();
		canvas.setPenColor(colorPicker.getValue(), rgb);
	}

	/**
	 * Sets starting color as Black.
	 */
	@Override
	protected Color getStartColor() {
		return Color.BLACK;
	}

}
