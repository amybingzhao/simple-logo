package GUIPackage;

import javafx.scene.control.ColorPicker;

public class GUIObjectColorPickerBackground extends GUIObjectColorPicker {

	public GUIObjectColorPickerBackground(GUICanvas canvas, String pickerLabel) {
		super(canvas, pickerLabel);
	}

	@Override
	void handleEvent(ColorPicker colorPicker) {
		canvas.getBackgroundGraphicsContext().setFill(colorPicker.getValue());
		canvas.getBackgroundGraphicsContext().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}

}
