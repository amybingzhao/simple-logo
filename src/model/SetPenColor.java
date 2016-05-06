package model;

import guipackage.CanvasMain;

public class SetPenColor extends DisplayNode {
	private static final String SET_PEN_COLOR = "SetPenColor ";

	/**
	 * Sets the pen color to the one specified by the index val in the palette.
	 */
	@Override
	protected void performCanvasOperation(CanvasMain canvas, double val) {
		canvas.getPen().setMyPenColor((int) val);
	}
	
	/**
	 * Returns the class name and its children.
	 */
	@Override
	public String toString() {
		return SET_PEN_COLOR + childrenToString();
	}
}
