package Model;

import java.util.List;

/**
 * HideTurtle function.
 * @author amyzhao
 *
 */
public class HideTurtle extends Node {

	private static final String HIDETURTLE = "hideturtle ";

	/**
	 * Sets the turtle to invisible.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> turtles = getActiveTurtles();
		for (int i = 0; i < turtles.size(); i++) {
			turtles.get(i).hide();
		}
		return 0;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return HIDETURTLE;
	}
}
