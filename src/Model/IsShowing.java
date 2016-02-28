package Model;

public class IsShowing extends Node {

	private static final String SHOWINGP = "showing? ";
	
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
		return SHOWINGP;
	}
}
