package model;

import guipackage.GUICanvas;

public class SetBackground extends DisplayNode {

	private static final String SET_BACKGROUND = "SetBackground ";
	
	@Override
	protected void performCanvasOperation(GUICanvas canvas, double val) {
		canvas.setBackgroundColor((int) val);
	}

	@Override
	public String toString() {
		return SET_BACKGROUND + childrenToString();
	}
}
