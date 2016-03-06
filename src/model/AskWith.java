package model;

import java.util.ArrayList;
import java.util.List;

public class AskWith extends TurtleNode {

	private static final String ASKWITH = "askwith ";
	private static final int CONDITION = 0;
	private static final int COMMANDS = 1;
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> origActiveList = getActiveTurtles();
		List<Turtle> allTurtles = getTurtles();
		List<Double> activeTurtleIDs = new ArrayList<Double>();
		IFunctions condition = getChildren().get(CONDITION);
		
		inactivateAllTurtles();
		for (int i = 0; i < allTurtles.size(); i++) {
			allTurtles.get(i).activate();
			allTurtles.get(i).setAsCurrentTurtle();
			if (condition.interpret(commandDict, varDict) == 1) {
				activeTurtleIDs.add(allTurtles.get(i).getID());
			}
			allTurtles.get(i).inactivate();
		}
		
		// only activates the ones listed in turtleIDs
		for (int i = 0; i < activeTurtleIDs.size(); i++) {
			Turtle turtle = getTurtleByID(activeTurtleIDs.get(i));
			if (turtle != null) {
				turtle.setAsCurrentTurtle();
				turtle.activate();
				turtle.noLongerCurrentTurtle();
			} else {
				createTurtle(activeTurtleIDs.get(i));
			}
		}
		
		double ret = getChildren().get(COMMANDS).interpret(commandDict, varDict);
		
		inactivateAllTurtles();
		for (int i = 0; i < origActiveList.size(); i++) {
			Turtle turtle = getTurtleByID(origActiveList.get(i).getID());
			if (turtle != null) {
				turtle.setAsCurrentTurtle();
				turtle.activate();
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
		return ASKWITH + getChildren().get(CONDITION) + " " + getChildren().get(COMMANDS);
	}
}