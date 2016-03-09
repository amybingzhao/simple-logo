package model;

import java.util.Collections;
import java.util.List;

public class Tell extends TurtleNode {

	private static final String TELL = "Tell ";
	private static final int TURTLE_IDS = 0;
	@Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		List<Double> turtleIDs = createListFromCommandList((CommandList) getChildren().get(TURTLE_IDS), commandDict, varDict);
		
		// creates all up through the max, so tell [ 100 ] creates 100 turtles; tell [ 1 2 5 ] checks 1-5
		activateTurtles(Collections.max(turtleIDs));	
		return turtleIDs.get(turtleIDs.size() - 1);
	}

	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		return 0;
	}

	@Override
	public String toString() {
		return TELL + childrenToString();
	}
}
