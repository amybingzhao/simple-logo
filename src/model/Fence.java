package model;

import guipackage.GUICanvas;

/**
 * @author blakekaplan
 */
public class Fence extends DisplayNode{

    private static final String FENCE = "Fence";

    /**
     * Abstract method that performs some operation on the canvas.
     *
     * @param canvas : canvas to act on.
     * @param val    : value to use for operation (may be value or index).
     */
    @Override
    protected void performCanvasOperation(GUICanvas canvas, double val) {
        canvas.setBoundsType(Bounds.Fence);
    }

    /**
     * Returns the class name and its children.
     */
    @Override
    public String toString() {
        return FENCE;
    }
}
