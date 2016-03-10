package model;

import guipackage.GUICanvas;

public class SetPenSize extends DisplayNode {
	private static final String SET_PEN_SIZE = "SetPenSize ";
	
	@Override
	protected void performCanvasOperation(GUICanvas canvas, double val) {
		canvas.getPen().setMyPenSize(val);
	}

	@Override
	public String toString() {
		return SET_PEN_SIZE + childrenToString();
	}
}
