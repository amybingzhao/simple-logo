package model;

/**
 * Forward function.
 *
 * @author amyzhao
 */
public class Forward extends TurtleNode {

	private static final String FORWARD = "Forward ";

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
		double dist = applyChildren(0, commandDict, varDict);
		return turtle.move(dist);
	}

	/**
	 * Returns the required user input for this command.
	 */
	@Override
	public String toString() {
		return FORWARD + childrenToString();
	}
}