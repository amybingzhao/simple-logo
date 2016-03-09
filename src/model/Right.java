package model;

/**
 * Right function.
 * @author amyzhao
 *
 */
public class Right extends TurtleNode {

	private static final String RIGHT = "Right ";

	/**
	 * Rotates the turtle CW by the given number of degrees.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		turtle.setDirection(turtle.getDirection() + applyChildren(0, commandDict, varDict));
		return applyChildren(0, commandDict, varDict);
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return RIGHT + childrenToString();
	}	
}
