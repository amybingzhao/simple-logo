package model;

import guipackage.GUICanvas;

public class Stamp extends DisplayNode {

	private static final String STAMP = "Stamp ";

	/**
	 * Draws a stamp for each active turtle.
	 */
	@Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		return getCanvas().drawStamps();
	}
				
	/**
	 * Not used in this class.
	 */
	@Override
	protected double performCanvasOperation(GUICanvas canvas, double val) {
		return 1;
	}

	/**
	 * Returns the class name and its children.
	 */
	@Override
	public String toString() {
		return STAMP;
	}

}
