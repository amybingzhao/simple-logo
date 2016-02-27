package GUIPackage;

import javafx.scene.control.ColorPicker;

public class GUIObjectColorPickerBackground extends GUIObjectColorPicker {

	public GUIObjectColorPickerBackground(GUICanvasAndOptions canvas, String pickerLabel, int xPos, int yPos) {
		super(canvas, pickerLabel, xPos, yPos);
	}

	@Override
	void handleEvent(ColorPicker colorPicker) {
		canvas.getGraphicsContext().setFill(colorPicker.getValue());
		canvas.getGraphicsContext().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}

}
