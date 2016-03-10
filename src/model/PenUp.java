package model;

/**
 * PenUp function.
 * @author amyzhao
 *
 */
public class PenUp extends TurtleNode {

	private static final String PENUP = "PenUp ";

	/**
     * Lifts pen up for current turtle so trail will no longer show.
     * @param commandDict
     * @param varDict
     */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		turtle.setPenUp(true);
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
