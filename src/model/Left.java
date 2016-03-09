package model;

/**
 * Left function.
 *
 * @author amyzhao
 */
public class Left extends TurtleNode {

    private static final String LEFT = "Left ";

    /**
     * Rotates the turtle CCW the given number of degrees.
     *
     * @param commandDict
     * @param varDict
     */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		double leftDegrees = applyChildren(0, commandDict, varDict);
		turtle.setDirection(turtle.getDirection() - leftDegrees);
		return leftDegrees;
	}

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        return LEFT + childrenToString();
    }
}
