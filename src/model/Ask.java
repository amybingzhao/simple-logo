package model;

import java.util.Collections;
import java.util.List;

public class Ask extends TurtleNode {

	private static final String ASK = "ask ";
	private static final int TURTLE_IDS = 0;
	private static final int COMMANDS = 1;
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> origActiveList = getActiveTurtles();
		List<Double> turtleIDs = createListFromCommandList((CommandList) getChildren().get(TURTLE_IDS), commandDict, varDict);
		
		// only activates the ones listed in turtleIDs
		for (int i = 0; i < turtleIDs.size(); i++) {
			Turtle turtle = getTurtleByID(turtleIDs.get(i));
			if (turtle != null) {
				turtle.setAsCurrentTurtle();
				turtle.activate();
				turtle.noLongerCurrentTurtle();
			} else {
				createTurtle(turtleIDs.get(i));
			}
		}
		
		double ret = getChildren().get(COMMANDS).interpret(commandDict, varDict);
		
		for (int i = 0; i < getTurtles().size(); i++) {
			Turtle turtle = getTurtleByID(i);
			if (turtle != null) {
				turtle.setAsCurrentTurtle();
				if (origActiveList.contains(turtle)) {
					turtle.activate();
				} else {
					turtle.inactivate();
				}
				turtle.noLongerCurrentTurtle();
			}
		}
		
		return ret;
	}

	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		return 0;
	}
	
	@Override
	public String toString() {
		return ASK + getChildren().get(TURTLE_IDS) + " " + getChildren().get(COMMANDS);
	}
}
