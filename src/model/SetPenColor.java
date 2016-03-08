package model;

import guipackage.GUICanvas;

public class SetPenColor extends DisplayNode {
	private static final String SET_PEN_COLOR = "setpencolor ";

	@Override
	protected void performCanvasOperation(GUICanvas canvas, double val) {
		canvas.setPenColor((int) val);
	}
	
	@Override
	public String toString() {
		return SET_PEN_COLOR + childrenToString();
	}
}
