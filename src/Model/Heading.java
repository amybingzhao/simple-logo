package Model;

public class Heading extends Node {

	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		return turtle.getDirection();
	}

	@Override
	public String toString() {
		return "Heading";
	}

}
