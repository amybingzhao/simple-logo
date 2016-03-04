package Model;

import java.util.List;

/**
 * XCoordinate function.
 * @author amyzhao
 *
 */
public class XCoordinate extends TurtleNode {

	private static final String XCOR = "xcor ";

	/**
	 * Returns the turtle's current x-coordinate.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> turtles = getActiveTurtles();
		double curX = 0;
		for (int i = 0; i < turtles.size(); i++) {
			curX = turtles.get(i).getCurX();
		}
		return curX;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return XCOR;
	}
}
