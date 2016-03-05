package model;

import java.util.List;

/**
 * PenUp function.
 * @author amyzhao
 *
 */
public class PenUp extends TurtleNode {

	private static final String PENUP = "penup ";

	/**
	 * Lifts pen up for current turtle so trail will no longer show.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		turtle.liftPenUp();
		return 0;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return PENUP;
	}



}
