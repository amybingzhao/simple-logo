package Model;

public class Turtles extends Node {

	private static final String TURTLES = "turtles ";
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		return getTurtles().size();
	}

	@Override
	public String toString() {
		return TURTLES;
	}

}
