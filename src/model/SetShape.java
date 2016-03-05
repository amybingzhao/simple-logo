package model;

public class SetShape extends DisplayNode {
	private static final String SET_SHAPE = "setshape ";
	private static final int INDEX = 0;
	
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		//getCanvas().setTurtleShape(getChildren().get(INDEX).interpret(commandDict, varDict));
		return getChildren().get(INDEX).interpret(commandDict, varDict);
	}

	@Override
	public String toString() {
		return SET_SHAPE + getChildren().get(INDEX).toString();
	}
}
