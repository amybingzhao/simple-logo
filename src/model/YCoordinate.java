package model;

/**
 * YCoordinate function.
 * @author amyzhao
 *
 */
public class YCoordinate extends TurtleNode {

	private static final String YCOR = "ycor ";

	/**
	 * Returns the turtle's current y-coordinate.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		return turtle.getCurY();
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return YCOR;
	}


}
