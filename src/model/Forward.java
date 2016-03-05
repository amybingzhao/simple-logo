package model;

import java.util.List;

/**
 * Forward function.
 *
 * @author amyzhao
 */
public class Forward extends TurtleNode {

	private static final String FORWARD = "forward ";
	private static final int DISTANCE = 0;

	/**
	 * Moves the turtle forward the given distance.
	 *
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict,
			VariableDictionary varDict)
					throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
		double dist = children.get(DISTANCE).interpret(commandDict, varDict);

		if (turtle != null) {
			turtle.move(dist);
		}

		return dist;
	}

	/**
	 * Returns the required user input for this command.
	 */
	@Override
	public String toString() {
		List<Node> children = getChildren();
		return FORWARD + children.get(DISTANCE).toString();
	}
}