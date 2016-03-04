package Model;

import java.util.List;

/**
 * PenDown function.
 * @author amyzhao
 *
 */
public class PenDown extends TurtleNode {

	private static final String PENDOWN = "pendown ";

	/**
	 * Puts the turtle's pen down so trail will now show.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> turtles = getActiveTurtles();
		for (int i = 0; i < turtles.size(); i++) {
			turtles.get(i).putPenDown();
		}
		return 1;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return PENDOWN;
	}

}
