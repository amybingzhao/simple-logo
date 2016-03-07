package model;

import java.util.List;

/**
 * Forward function.
 *
 * @author amyzhao
 */
public class Forward extends TurtleNode {

	private static final String FORWARD = "forward ";

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
		double dist = 0;
		for (int i = 0; i < children.size(); i++) {
			dist = turtle.move(children.get(i).interpret(commandDict, varDict));
		}
		return dist;
	}

	/**
	 * Returns the required user input for this command.
	 */
	@Override
	public String toString() {
		return FORWARD + childrenToString();
	}
}