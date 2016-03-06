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
		List<Double> activeTurtleIDs = checkTurtlesForCondition(getTurtles(), commandDict, varDict);		
		
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

	private List<Double> checkTurtlesForCondition(List<Turtle> allTurtles, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Double> turtleIDs = new ArrayList<Double>();
		inactivateAllTurtles();
		for (int i = 0; i < allTurtles.size(); i++) {
			allTurtles.get(i).activate();
			allTurtles.get(i).setAsCurrentTurtle();
			if (getChildren().get(CONDITION).interpret(commandDict, varDict) == 1) {
				turtleIDs.add(allTurtles.get(i).getID());
			}
			allTurtles.get(i).inactivate();
		}
		return turtleIDs;
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