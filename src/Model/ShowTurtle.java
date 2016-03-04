package Model;

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
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> turtles = getActiveTurtles();
		for (int i = 0; i < turtles.size(); i++) {
			turtles.get(i).show();
		}
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
