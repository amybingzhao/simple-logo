package model;

import guipackage.GUICanvas;

public class SetPenSize extends DisplayNode {
	private static final String SET_PEN_SIZE = "setpensize ";
	
	@Override
	protected void performCanvasOperation(GUICanvas canvas, double val) {
		canvas.setPenSize(val);
	}

	@Override
	public String toString() {
		return SET_PEN_SIZE + childrenToString();
	}
}
