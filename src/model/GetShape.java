package model;

import guipackage.GUICanvas;

public class GetShape extends DisplayNode {

	private static final String SHAPE = "GetShape ";
	
	@Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		return getCanvas().getTurtleImageView().getTurtleShapeIndex();
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
