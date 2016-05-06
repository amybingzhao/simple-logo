package model;

import guipackage.CanvasMain;

public class SetShape extends DisplayNode {
	private static final String SET_SHAPE = "SetShape ";

	/**
	 * Sets the turtle image to that indicated by the given index.
	 */
	@Override
	protected void performCanvasOperation(CanvasMain canvas, double val) {
		canvas.getImageManager().setTurtleImage((int) val);
	}

	/**
	 * Returns the class name and its children.
	 */
	@Override
	public String toString() {
		return SET_SHAPE + childrenToString();
	}
}
