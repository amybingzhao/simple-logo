package model;

import java.util.List;

/**
 * ShowTurtle function.
 * @author amyzhao
 *
 */
public class ShowTurtle extends TurtleNode {

	private static final String SHOWTURTLE = "showturtle ";
	
	/**
	 * Sets the turtle to visible and returns 1.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		turtle.show();
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
