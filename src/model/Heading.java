package model;

/**
 * Heading function.
 * @author amyzhao
 *
 */
public class Heading extends TurtleNode {

	private static final String HEADING = "heading ";

	/**
	 * Returns the turtle's current direction.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		return turtle.getDirection();
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return HEADING;
	}



}
