package model;

import guipackage.GUICanvas;

/**
 * @author blakekaplan
 */
public class Wrap extends DisplayNode {

    private static final String WRAP = "Wrap";

    /**
     * Abstract method that performs some operation on the canvas.
     *
     * @param canvas : canvas to act on.
     * @param val    : value to use for operation (may be value or index).
     */
    @Override
    protected void performCanvasOperation(GUICanvas canvas, double val) {
        canvas.setBoundsType(Bounds.Wrap);
    }

    /**
     * Returns the class name and its children.
     */
    @Override
    public String toString() {
        return WRAP;
    }
}
