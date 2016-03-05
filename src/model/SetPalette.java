package model;

import java.util.List;

import javafx.scene.paint.Color;

public class SetPalette extends DisplayNode {

	private static final String SET_PALETTE = "setpalette ";
	private static final int INDEX = 0;
	private static final int R = 1;
	private static final int G = 2;
	private static final int B = 3;
	private static final double ALPHA = 1.0;
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
		Color color = new Color(children.get(R).interpret(commandDict, varDict),
				children.get(G).interpret(commandDict, varDict),
				children.get(B).interpret(commandDict, varDict),
				ALPHA);
		//getCanvas().setPaletteIndex(children.get(INDEX).interpret(commandDict, varDict), color);
		return children.get(INDEX).interpret(commandDict, varDict);
	}

	@Override
	public String toString() {
		List<Node> children = getChildren();
		return SET_PALETTE + children.get(INDEX).toString() + " " + 
				children.get(R).toString() + " " + children.get(G).toString() + " " + children.get(B).toString();
	}

}
