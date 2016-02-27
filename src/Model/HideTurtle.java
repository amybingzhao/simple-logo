package Model;

public class HideTurtle extends Node {

	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		turtle.hide();
		return 0;
	}

	@Override
	public String toString() {
		return "HideTurtle";
	}
}
