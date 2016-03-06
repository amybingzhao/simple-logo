package model;

import java.util.List;

/**
 * IsPenDown function.
 * @author amyzhao
 *
 */
public class IsPenDown extends TurtleNode {

	private static final String PENDOWNP = "pendown? ";

	/**
	 * If the turtle's pen is down, returns 1; else returns 0.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		double ret = 0;
		if (turtle.isPenUp()) {
			ret = 0;
		} else {
			ret = 1;
		}
		return 0;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return PENDOWNP;
	}	
}
