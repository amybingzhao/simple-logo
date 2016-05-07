package model;

import guipackage.GUICanvas;

public class SetBackground extends DisplayNode {

	private static final String SET_BACKGROUND = "SetBackground ";
	
	/**
	 * Sets the canvas's background color to the color on the palette and index val.
	 */
	@Override
	protected double performCanvasOperation(GUICanvas canvas, double val) {
		canvas.getBackgroundCanvas().setBackgroundColor((int) val);
        return val;
	}

	/**
	 * Returns the class name and its children
	 */
	@Override
	public String toString() {
		return SET_BACKGROUND + childrenToString();
	}
}
