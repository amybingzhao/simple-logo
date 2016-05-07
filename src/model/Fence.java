package model;

import guipackage.GUICanvas;

/**
 * @author blakekaplan
 */
public class Fence extends DisplayNode{

    private static final String FENCE = "Fence";
    private static final int FENCE_VALUE = 3;

    /**
     * Abstract method that performs some operation on the canvas.
     *
     * @param canvas : canvas to act on.
     * @param val    : value to use for operation (may be value or index).
     */
    @Override
    protected double performCanvasOperation(GUICanvas canvas, double val) {
        //Changes the Bounds type in the GUICanvas
        canvas.setBoundsType(Bounds.Fence);
        return FENCE_VALUE;
    }

    /**
     * Returns the class name and its children.
     */
    @Override
    public String toString() {
        return FENCE;
    }
}
