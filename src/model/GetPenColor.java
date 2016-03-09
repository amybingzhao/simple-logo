package model;

import guipackage.GUICanvas;

public class GetPenColor extends DisplayNode {

	private static final String PEN_COLOR = "GetPenColor ";
	
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		return getPen().getMyPenColorIndex();
	}
	
	@Override
	protected void performCanvasOperation(GUICanvas canvas, double val) {
		//not used
	}

	@Override
	public String toString() {
		return PEN_COLOR;
	}
}
