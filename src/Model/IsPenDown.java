package Model;

import java.util.List;

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
		List<Turtle> turtles = getActiveTurtles();
		double ret = 0;
		for (int i = 0; i < turtles.size(); i++) {
			if (turtles.get(i).isPenUp()) {
				ret = 0;
			} else {
				ret = 1;
			}
		}
		return ret;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return PENDOWNP;
	}
}
