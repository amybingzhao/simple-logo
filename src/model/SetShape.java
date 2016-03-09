package model;

import guipackage.GUICanvas;

public class SetShape extends DisplayNode {
	private static final String SET_SHAPE = "SetShape ";

	@Override
	protected void performCanvasOperation(GUICanvas canvas, double val) {
		canvas.setTurtleShape((int) val);
	}

	@Override
	public String toString() {
		return SET_SHAPE + childrenToString();
	}
}
