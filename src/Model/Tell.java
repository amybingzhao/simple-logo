package Model;

import java.util.Collections;
import java.util.List;

public class Tell extends TurtleNode {

	private static final String TELL = "tell ";
	private static final int TURTLE_IDS = 0;
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Double> turtleIDs = createListFromCommandList((CommandList) getChildren().get(TURTLE_IDS), commandDict, varDict);
		double maxID = Collections.max(turtleIDs);
		
		// creates all up through the max, so tell [ 100 ] creates 100 turtles; tell [ 1 2 5 ] checks 1-5
		for (double i = 0; i <= maxID; i++) {
			Turtle turtle = getTurtleByID(i);
			if (turtle != null) {
				turtle.activate();
			} else {
				createTurtle(i);
			}
		}
		
		return turtleIDs.get(turtleIDs.size() - 1);
	}

	@Override
	public String toString() {
		return TELL + getChildren().get(TURTLE_IDS).toString();
	}

	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return 0;
	}


}
