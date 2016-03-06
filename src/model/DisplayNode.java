package model;

import guipackage.GUICanvas;

public abstract class DisplayNode extends Node {
	
	private GUICanvas myCanvas;

	public void setCanvas(GUICanvas canvas) {
		myCanvas = canvas;
	}
	
	protected GUICanvas getCanvas() {
		return myCanvas;
	}
}
