package model;

public class Turtles extends TurtleNode {

	private static final String TURTLES = "turtles ";
	@Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		return getTurtles().size();
	}

	@Override
	public String toString() {
		return TURTLES;
	}

	@Override
    protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

}
