package model;

import guipackage.GUICanvas;

public class Stamp extends DisplayNode {

	private static final String STAMP = "Stamp ";

	@Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		return getCanvas().drawStamps();
	}
				
	@Override
	protected void performCanvasOperation(GUICanvas canvas, double val) {
		// do nothing
	}

	@Override
	public String toString() {
		return STAMP;
	}

}
