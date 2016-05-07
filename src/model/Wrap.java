package model;

import guipackage.GUICanvas;

/**
 * @author blakekaplan
 */
public class Wrap extends DisplayNode {

    private static final String WRAP = "Wrap";
    private static final int WRAP_VALUE = 1;

    /**
     * Abstract method that performs some operation on the canvas.
     *
     * @param canvas : canvas to act on.
     * @param val    : value to use for operation (may be value or index).
     */
    @Override
    protected double performCanvasOperation(GUICanvas canvas, double val) {
        //Changes the Bounds type in the GUICanvas
        canvas.setBoundsType(Bounds.Wrap);
        return WRAP_VALUE;
    }

    /**
     * Returns the class name and its children.
     */
    @Override
    public String toString() {
        return WRAP;
    }
}
