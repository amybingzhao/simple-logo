package Model;

import java.util.List;

public class Right extends Node {

	private static final String RIGHT = "right ";
	private static final int ONE_REVOLUTION = 360;
	private static final int DEGREES = 0;

	@Override
	public double interpret() {
		List<Node> children = getChildren();
		double degrees = children.get(DEGREES).interpret();		
		Turtle turtle = getTurtle();
		turtle.setDirection(turtle.getDirection() + degrees);
		return degrees;
	}

	@Override
	public String toString() {
		List<Node> children = getChildren();
		return RIGHT + children.get(DEGREES).interpret();
	}
}
