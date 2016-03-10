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
     *  @param commandDict
     * @param varDict
     */
    @Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		turtle.setDirection(turtle.getDirection() - applyChildren(0, commandDict, varDict));
		return applyChildren(0, commandDict, varDict);
	}

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        return LEFT + childrenToString();
    }
}
