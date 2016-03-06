package model;

import java.util.List;

/**
 * IsShowing function.
 * @author amyzhao
 *
 */
public class IsShowing extends TurtleNode {

	private static final String SHOWINGP = "showing? ";

	/**
	 * Returns 1 if the turtle is showing on the canvas; 0 otherwise.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		double ret = 0;
		if (turtle.showing()) {
			ret = 1;
		} else {
			ret = 0;
		}
		return ret;
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return SHOWINGP;
	}
}
