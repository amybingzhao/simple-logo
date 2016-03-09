package model;

/**
 * ShowTurtle function.
 * @author amyzhao
 *
 */
public class ShowTurtle extends TurtleNode {

	private static final String SHOWTURTLE = "ShowTurtle ";
	
	/**
	 * Sets the turtle to visible and returns 1.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		turtle.setVisible(true);
		return 1;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return SHOWTURTLE;
	}
}
