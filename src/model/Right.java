package model;

import java.util.List;

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
		List<IFunctions> children = getChildren();
		double degrees = 0;
		for (int i = 0; i < children.size(); i++) {
			degrees = getChildren().get(i).interpret(commandDict, varDict);
			turtle.setDirection(turtle.getDirection() + degrees);
		}
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
