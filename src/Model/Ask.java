package Model;

import java.util.Collections;
import java.util.List;

public class Ask extends Node {

	private static final int TURTLE_IDS = 0;
	private static final int COMMANDS = 1;
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> origActiveList = getActiveTurtles();
		List<Double> turtleIDs = createListFromCommandList((CommandList) getChildren().get(TURTLE_IDS), commandDict, varDict);
		double maxID = Collections.max(turtleIDs);

		for (int i = 0; i <= maxID; i++) {
			Turtle turtle = getTurtleByID(turtleIDs.get(i));
			if (turtle != null) {
				turtle.activate();
			} else {
				createTurtle(turtleIDs.get(i));
			}
		}
		
		double ret = getChildren().get(COMMANDS).interpret(commandDict, varDict);
		
		for (int i = 0; i <= maxID; i++) {
			Turtle turtle = getTurtleByID(turtleIDs.get(i));
			if (origActiveList.contains(turtle)) {
				turtle.activate();
			} else {
				turtle.inactivate();
			}
		}
		
		return ret;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
