package Model;

public class Heading extends Node {

	private static final String HEADING = "heading ";
	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		return turtle.getDirection();
	}

	@Override
	public String toString() {
		return HEADING;
	}

}
