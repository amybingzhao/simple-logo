package Model;

/**
 * YCoordinate function.
 * @author amyzhao
 *
 */
public class YCoordinate extends Node {

	private static final String YCOR = "ycor ";
	
	/**
	 * Returns the turtle's current y-coordinate.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		Turtle turtle = getTurtle();
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
