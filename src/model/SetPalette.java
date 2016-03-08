package model;

import java.util.List;
import guipackage.GUICanvas;

public class SetPalette extends DisplayNode {

	private static final String SET_PALETTE = "setpalette ";
	private static final int INDEX = 0;
	private static final int[] RGB_INDICES = new int[]{1,2,3};

	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<IFunctions> children = getChildren();
		StringBuilder rgb = new StringBuilder();
		for (int i = 0; i < RGB_INDICES.length; i++) {
			rgb.append(Integer.toString((int) children.get(RGB_INDICES[i]).interpret(commandDict, varDict)));
			rgb.append(" ");
		}
		getCanvas().setPalette(rgb.toString().trim(), (int) children.get(INDEX).interpret(commandDict, varDict));
		return children.get(INDEX).interpret(commandDict, varDict);
	}
	
	@Override
	protected void performCanvasOperation(GUICanvas canvas, double val) {
		//not used
	}
	
	@Override
	public String toString() {
		return SET_PALETTE + childrenToString();
	}

}
