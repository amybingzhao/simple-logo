package model;

import guipackage.Bounds;
import guipackage.GUICanvas;

public class Fence extends DisplayNode {
	private static final String FENCE = "Fence";
	private static final int RETURN_VAL = 3;

	@Override
	protected double performCanvasOperation(GUICanvas canvas, double val) {
		canvas.setBounds(Bounds.Fence);
		return RETURN_VAL;
	}

	@Override
	public String toString() {
		return FENCE + childrenToString();
	}

}