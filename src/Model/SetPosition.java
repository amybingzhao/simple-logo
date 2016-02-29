package Model;

import java.util.List;

public class SetPosition extends Node {

	private static final String SETXY = "setxy ";
	private static final int X = 0;
	private static final int Y = 1;
	
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		Turtle turtle = getTurtle();
		double dist = turtle.calcDistance(children.get(X).interpret(), children.get(Y).interpret());
		turtle.turnTowards(children.get(X).interpret(), children.get(Y).interpret());
		turtle.move(dist);
		return dist;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		List<Node> children = getChildren();
		return SETXY + children.get(X).toString() + " " + children.get(Y).toString();
	}

}
