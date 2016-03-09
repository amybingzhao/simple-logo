package model;

/**
 * PenDown function.
 * @author amyzhao
 *
 */
public class PenDown extends TurtleNode {

	private static final String PENDOWN = "PenDown ";

	/**
	 * Puts the turtle's pen down so trail will now show.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		turtle.setPenUp(false);
		return 1;
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return PENDOWN;
	}
}
