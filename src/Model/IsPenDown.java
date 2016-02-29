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

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return PENDOWNP;
	}
}
