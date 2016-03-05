package model;

public class SetBackground extends DisplayNode {

	private static final String SET_BACKGROUND = "setbackground ";
	private static final int INDEX = 0;
	
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		//getCanvas().setBackgroundColor(getChildren().get(INDEX).interpret(commandDict, varDict));
		return getChildren().get(INDEX).interpret(commandDict, varDict);
	}

	@Override
	public String toString() {
		return SET_BACKGROUND + getChildren().get(INDEX).toString();
	}
	
	
}
