package model;

import guipackage.GUICanvas;

public class SetPenColor extends DisplayNode {
	private static final String SET_PEN_COLOR = "SetPenColor ";

	@Override
	protected void performCanvasOperation(GUICanvas canvas, double val) {
		canvas.getPen().setMyPenColor((int) val);
//		canvas.setPenColor((int) val);
	}
	
	@Override
	public String toString() {
		return SET_PEN_COLOR + childrenToString();
	}
}
