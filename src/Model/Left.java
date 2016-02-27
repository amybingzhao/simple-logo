package Model;

import java.util.List;

public class Left extends Node {

	private static final int ONE_REVOLUTION = 360;

	@Override
	public double interpret() {
		List<Node> children = getChildren();
		double degrees = children.get(0).interpret();
		Turtle turtle = getTurtle();
		double newDir = turtle.getDirection() - degrees;
		
		if (newDir < 0) {
			newDir = newDir + ONE_REVOLUTION;
		}
		turtle.setDirection(newDir);

		return degrees;
	}

	@Override
	public String toString() {
		List<Node> children = getChildren();
		return "Left " + children.get(0).interpret();
	}
}
