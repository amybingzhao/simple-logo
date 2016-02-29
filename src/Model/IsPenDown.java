package Model;

public class IsPenDown extends Node {

	private static final String PENDOWNP = "pendown? ";
	
	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		if (turtle.penUp()) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public String toString() {
		return PENDOWNP;
	}
}
