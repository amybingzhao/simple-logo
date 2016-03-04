package Model;

import java.util.List;

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
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> turtles = getActiveTurtles();
		double curY = 0;
		for (int i = 0; i < turtles.size(); i++) {
			curY = turtles.get(i).getCurY();
		}
		return curY;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return YCOR;
	}
}
