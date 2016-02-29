package Model;

import java.util.List;

public class SetHeading extends Node {
	
	private static final String SETHEADING = "setheading ";
	private static final int DEGREES = 0;
	
	/**
	 * Turns the turtle towards to the given degrees, where 0 is facing north and rotating CW is positive.
	 */
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		Turtle turtle = getTurtle();
		double curDir = turtle.getDirection();
		
		turtle.setDirection(children.get(DEGREES).interpret());

		return children.get(DEGREES).interpret() - curDir;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		List<Node> children = getChildren();
		return SETHEADING + children.get(DEGREES).toString();
	}
}
