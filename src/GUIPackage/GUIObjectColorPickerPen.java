package GUIPackage;

import javafx.scene.control.ColorPicker;

public class GUIObjectColorPickerPen extends GUIObjectColorPicker {

	public GUIObjectColorPickerPen(GUICanvasAndOptions canvas, String pickerLabel, int xPos, int yPos) {
		super(canvas, pickerLabel, xPos, yPos);
	}

	@Override
	void handleEvent(ColorPicker colorPicker) {
		canvas.getGraphicsContext().setStroke(colorPicker.getValue());
	}

}
