package model;

import java.util.List;

/**
 * Right function.
 * @author amyzhao
 *
 */
public class Right extends TurtleNode {

	private static final String RIGHT = "right ";
	private static final int ONE_REVOLUTION = 360;
	private static final int DEGREES = 0;

	/**
	 * Rotates the turtle CW by the given number of degrees.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		double degrees = getChildren().get(DEGREES).interpret(commandDict, varDict);		
		turtle.setDirection(turtle.getDirection() + degrees);
		return degrees;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return RIGHT + childrenToString();
	}	
}
