package model;

/**
 * XCoordinate function.
 * @author amyzhao
 *
 */
public class XCoordinate extends TurtleNode {

	private static final String XCOR = "XCoordinate ";

	/**
     * Returns the turtle's current x-coordinate.
     * @param commandDict
     * @param varDict
     */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		return turtle.getCurX();
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return XCOR;
	}
}
