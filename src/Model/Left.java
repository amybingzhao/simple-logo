package Model;

import java.util.List;

public class Left extends Node {

	private static final int ONE_REVOLUTION = 360;
	private static final int DEGREES = 0;

	@Override
	public double interpret() {
		List<Node> children = getChildren();
		double degrees = children.get(DEGREES).interpret();
		Turtle turtle = getTurtle();
		turtle.setDirection(turtle.getDirection() - degrees);
		return degrees;
	}

	@Override
	public String toString() {
		List<Node> children = getChildren();
		return "Left " + children.get(DEGREES).interpret();
	}
}
