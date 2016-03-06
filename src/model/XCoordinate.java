package model;

import java.util.List;

/**
 * XCoordinate function.
 * @author amyzhao
 *
 */
public class XCoordinate extends TurtleNode {

	private static final String XCOR = "xcor ";

	/**
	 * Returns the turtle's current x-coordinate.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		return turtle.getCurX();
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return XCOR;
	}
}
