package Model;

/**
 * IsPenDown function.
 * @author amyzhao
 *
 */
public class IsPenDown extends Node {

	private static final String PENDOWNP = "pendown? ";
	
	/**
	 * If the turtle's pen is down, returns 1; else returns 0.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		Turtle turtle = getTurtle();
		if (turtle.isPenUp()) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return PENDOWNP;
	}
}
