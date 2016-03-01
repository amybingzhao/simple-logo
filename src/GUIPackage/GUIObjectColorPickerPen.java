package GUIPackage;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class GUIObjectColorPickerPen extends GUIObjectColorPicker {

	public GUIObjectColorPickerPen(GUICanvas canvas, String pickerLabel) {
		super(canvas, pickerLabel);
	}

	@Override
	void handleEvent(ColorPicker colorPicker) {
		canvas.setPenColor(colorPicker.getValue());
	}

	@Override
	Color getStartColor() {
		return Color.BLACK;
	}

}
