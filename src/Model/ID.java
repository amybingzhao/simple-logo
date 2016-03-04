package Model;

import java.util.List;

public class ID extends TurtleNode {

	private static final String ID = "id ";
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> curTurtles = getTurtles();
		for (int i = 0; i < curTurtles.size(); i++) {
			if (curTurtles.get(i).isCurrentTurtle()) {
				return curTurtles.get(i).getID();
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return ID;
	}

}
