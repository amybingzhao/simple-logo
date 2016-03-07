package model;

/**
 * Clearscreen function.
 * @author amyzhao
 *
 */
public class ClearScreen extends TurtleNode {

	private static final String CLEARSCREEN = "clearscreen ";

	/** 
	 * Moves the turtle back to (0, 0) and erases its trails; returns the distance the turtle moved to get back to (0, 0).
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		double dist = turtle.moveToHome();
		turtle.resetTurtle();

		return dist;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return CLEARSCREEN;
	}
}
