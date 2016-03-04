package Model;

import java.util.List;

/**
 * Right function.
 * @author amyzhao
 *
 */
public class Right extends Node {

	private static final String RIGHT = "right ";
	private static final int ONE_REVOLUTION = 360;
	private static final int DEGREES = 0;

	/**
	 * Rotates the turtle CW by the given number of degrees.
	 */
	@Override
	public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
		double degrees = children.get(DEGREES).interpret();		
		List<Turtle> turtles = getActiveTurtles();
		for (int i = 0; i < turtles.size(); i++) {
			turtles.get(i).setDirection(turtles.get(i).getDirection() + degrees);
		}
		return degrees;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		List<Node> children = getChildren();
		return RIGHT + children.get(DEGREES).toString();
	}
}
