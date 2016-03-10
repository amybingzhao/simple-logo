package model;

import guipackage.GUICanvas;

public class ClearStamps extends DisplayNode {

	private static final String CLEAR_STAMP = "ClearStamps ";

	@Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		getCanvas().clearStamps();
		return 1;
	}
				
	@Override
	protected void performCanvasOperation(GUICanvas canvas, double val) {
		// do nothing
	}

	@Override
	public String toString() {
		return CLEAR_STAMP;
	}

}
