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
	
	protected abstract void performCanvasOperation(GUICanvas canvas, double val);
	
	@Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		GUICanvas myCanvas = getCanvas();
		performCanvasOperation(myCanvas, getChildren().get(0).interpret(commandDict, varDict));
		return getChildren().get(0).interpret(commandDict, varDict);
	}

}
