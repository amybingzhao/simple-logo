package Model;

import java.util.List;

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
		List<Turtle> turtles = getActiveTurtles();
		double ret = 0;
		for (int i = 0; i < turtles.size(); i++) {
			if (turtles.get(i).showing()) {
				ret = 1;
			} else {
				ret = 0;
			}
		}
		return ret;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return SHOWINGP;
	}
}
