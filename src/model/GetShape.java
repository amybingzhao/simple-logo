package model;

import guipackage.GUICanvas;

public class GetShape extends DisplayNode {

	private static final String SHAPE = "shape ";
	
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		return getCanvas().getTurtleShapeIndex();
	}
	
	@Override
	protected void performCanvasOperation(GUICanvas canvas, double val) {
		//not used
	}

	@Override
	public String toString() {
		return SHAPE;
	}
}
