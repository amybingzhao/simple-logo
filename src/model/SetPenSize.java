package model;

public class SetPenSize extends DisplayNode {
	private static final String SET_PEN_SIZE = "setpensize ";
	private static final int PIXELS = 0;
	
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		//getCanvas().setPenSize(getChildren().get(INDEX).interpret(commandDict, varDict));
		return getChildren().get(PIXELS).interpret(commandDict, varDict);
	}

	@Override
	public String toString() {
		return SET_PEN_SIZE + childrenToString();
	}
}
