package Model;

/**
 * IsShowing function.
 * @author amyzhao
 *
 */
public class IsShowing extends Node {

	private static final String SHOWINGP = "showing? ";
	
	/**
	 * Returns 1 if the turtle is showing on the canvas; 0 otherwise.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		Turtle turtle = getTurtle();
		if (turtle.showing()) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return SHOWINGP;
	}
}
