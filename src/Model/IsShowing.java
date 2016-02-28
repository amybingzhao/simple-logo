package Model;

public class IsShowing extends Node {

	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		if (turtle.showing()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Showing?";
	}
}
