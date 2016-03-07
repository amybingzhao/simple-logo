package model;

public class SetPenColor extends DisplayNode {
	private static final String SET_PEN_COLOR = "setpencolor ";
	private static final int INDEX = 0;
	
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		getCanvas().setPenColor((int) getChildren().get(INDEX).interpret(commandDict, varDict));
		return getChildren().get(INDEX).interpret(commandDict, varDict);
	}

	@Override
	public String toString() {
		return SET_PEN_COLOR + childrenToString();
	}
}
