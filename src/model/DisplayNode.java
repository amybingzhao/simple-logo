package model;

import guipackage.GUICanvas;
import guipackage.GUICanvasPen;

import java.util.ResourceBundle;

public abstract class DisplayNode extends Node {

    private static final String VALUE = "Value";
    private static final int DEFAULT = 0;
    private static final String BOUNDS_BUNDLE = "model/boundshandling";
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
	 */
	protected abstract void performCanvasOperation(GUICanvas canvas, double val);
	
	/**
	 * Gets the canvas for this workspace and performs an operation on it.
	 */
	@Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		GUICanvas myCanvas = getCanvas();
        if (getChildren().isEmpty()) {
            performCanvasOperation(myCanvas, 0);
            if (ResourceBundle.getBundle(BOUNDS_BUNDLE).containsKey(toString())){
                return Double.parseDouble(ResourceBundle.getBundle(BOUNDS_BUNDLE).getString(toString() + VALUE));
            }
            else{
                return DEFAULT;
            }
        }
        else{
            performCanvasOperation(myCanvas, getChildren().get(0).interpret(commandDict, varDict));
            return getChildren().get(0).interpret(commandDict, varDict);
        }

	}

}
