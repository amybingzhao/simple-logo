package model;

import guipackage.GUICanvas;
import guipackage.GUICanvasPen;

public abstract class DisplayNode extends Node {
	private static final int VALUE = 0;
	private GUICanvas myCanvas;

	/**
	 * Sets the canvas for this node to the current canvas.
	 * @param canvas: current workspace canvas.
	 */
	public void setCanvas(GUICanvas canvas) {
		myCanvas = canvas;
	}
	
	/**
	 * Gets the canvas associated with this node.
	 * @return canvas associated with this node.
	 */
	protected GUICanvas getCanvas() {
		return myCanvas;
	}
	
	/**
	 * Pen for this node's canvas.
	 * @return pen for this canvas.
	 */
	protected GUICanvasPen getPen() {
		return myCanvas.getPen();
	}
	
	/**
	 * Abstract method that performs some operation on the canvas.
	 * @param canvas: canvas to act on.
	 * @param val: value to use for operation (may be value or index).
	 * @return 
	 */
	protected abstract double performCanvasOperation(GUICanvas canvas, double val);
	
	/**
	 * Gets the canvas for this workspace and performs an operation on it.
	 */
	@Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		GUICanvas myCanvas = getCanvas();
		return performCanvasOperation(myCanvas, setVal(commandDict, varDict));
	}
	
	private double setVal(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
		if (getChildren().isEmpty()) {
			return 0;
		} else {
			return getChildren().get(VALUE).interpret(commandDict, varDict);
		}
	}

}
