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
		Turtle turtle = getTurtle();
		turtle.setDirection(turtle.getDirection() + degrees);
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
