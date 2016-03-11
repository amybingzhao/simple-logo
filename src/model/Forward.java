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
	 *  @param commandDict
	 * @param varDict
     */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict,
			VariableDictionary varDict)
            throws ClassNotFoundException {
		double dist = applyChildren(0, commandDict, varDict);
		return turtle.move(dist);
	}

	/**
	 * Returns the class name and its children.
	 */
	@Override
	public String toString() {
		return FORWARD + childrenToString();
	}
}