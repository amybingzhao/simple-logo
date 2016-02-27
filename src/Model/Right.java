package Model;

import java.util.List;

public class Right extends Node {

	private static final int ONE_REVOLUTION = 360;

	@Override
	public double interpret() {
		List<Node> children = getChildren();
		double degrees = children.get(0).interpret();		
		Turtle turtle = getTurtle();
		turtle.setDirection(turtle.getDirection() + degrees);
		return degrees;
	}

	@Override
	public String toString() {
		List<Node> children = getChildren();
		return "Right " + children.get(0).interpret();
	}
}
