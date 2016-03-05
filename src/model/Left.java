package model;

import java.util.List;

/**
 * Left function.
 *
 * @author amyzhao
 */
public class Left extends TurtleNode {

    private static final String LEFT = "left ";
    private static final int DEGREES = 0;

    /**
     * Rotates the turtle CCW the given number of degrees.
     *
     * @param commandDict
     * @param varDict
     */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		double degrees = getChildren().get(DEGREES).interpret(commandDict, varDict);
		turtle.setDirection(turtle.getDirection() - degrees);
		return degrees;
	}

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        List<Node> children = getChildren();
        return LEFT + children.get(DEGREES).toString();
    }
}
