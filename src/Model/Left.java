package Model;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Left function.
 * @author amyzhao
 *
 */
public class Left extends Node {

	private static final String LEFT = "left ";
	private static final int DEGREES = 0;

	/**
	 * Rotates the turtle CCW the given number of degrees.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Override
	public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<Node> children = getChildren();
		double degrees = children.get(DEGREES).interpret();
		Turtle turtle = getActiveTurtle();
		turtle.setDirection(turtle.getDirection() - degrees);
		return degrees;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		List<Node> children = getChildren();
		return LEFT + children.get(DEGREES).toString();
	}
}
