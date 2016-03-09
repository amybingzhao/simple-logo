package model;

import java.util.List;

public class Ask extends TurtleNode {

	private static final String ASK = "Ask ";
	private static final int TURTLE_IDS = 0;
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Double> turtleIDs = createListFromCommandList((CommandList) getChildren().get(TURTLE_IDS), commandDict, varDict);
		return applyToTurtlesInList(turtleIDs, getActiveTurtles(), commandDict, varDict);
	}

	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		return 0;
	}
	
	@Override
	public String toString() {
		return ASK + childrenToString();
	}
}
