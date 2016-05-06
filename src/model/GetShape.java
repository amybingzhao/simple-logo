package model;

import guipackage.GUICanvas;

public class GetShape extends DisplayNode {

	private static final String SHAPE = "GetShape ";
	
	/**
	 * Gets the current turtle shape's index.
	 */
	@Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		return getCanvas().getTurtleImageView().getTurtleShapeIndex();
	}
	
	/**
	 * Not used for this function.
	 */
	@Override
	protected double performCanvasOperation(GUICanvas canvas, double val) {
		return val;
	}

	/**
	 * Returns the class name.
	 */
	@Override
	public String toString() {
		return SHAPE;
	}
}
