package model;

import java.util.List;

/**
 * SetHeading function.
 * @author amyzhao
 *
 */
public class SetHeading extends TurtleNode {
	
	private static final String SETHEADING = "setheading ";
	private static final int DEGREES = 0;
	
	/**
	 * Turns the turtle towards to the given degrees, where 0 is facing north and rotating CW is positive.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<IFunctions> children = getChildren();
		double curDir = turtle.getDirection();
		turtle.setDirection(children.get(DEGREES).interpret(commandDict, varDict));
		return children.get(DEGREES).interpret(commandDict, varDict) - curDir;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return SETHEADING + childrenToString();
	}
}
