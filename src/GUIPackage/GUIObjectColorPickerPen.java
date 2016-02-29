package GUIPackage;

import javafx.scene.control.ColorPicker;

public class GUIObjectColorPickerPen extends GUIObjectColorPicker {

	public GUIObjectColorPickerPen(GUICanvas canvas, String pickerLabel) {
		super(canvas, pickerLabel);
	}

	@Override
	void handleEvent(ColorPicker colorPicker) {
		canvas.getBackgroundGraphicsContext().setStroke(colorPicker.getValue());
	}

}
