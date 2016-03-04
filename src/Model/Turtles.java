package Model;

public class Turtles extends TurtleNode {

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

	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return 0;
	}

}
