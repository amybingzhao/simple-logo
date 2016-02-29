package Model;

import java.util.List;

public class Left extends Node {

	private static final String LEFT = "left ";
	private static final int DEGREES = 0;

	/**
	 * Rotates the turtle CCW the given number of degrees.
	 */
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		double degrees = children.get(DEGREES).interpret();
		Turtle turtle = getTurtle();
		turtle.setDirection(turtle.getDirection() - degrees);
		return degrees;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		List<Node> children = getChildren();
		return LEFT + children.get(DEGREES).interpret();
	}
}
