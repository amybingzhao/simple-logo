package Model;

public class PenDown extends Node {

	private static final String PENDOWN = "pendown ";
	
	/**
	 * Puts the turtle's pen down so trail will now show.
	 */
	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		turtle.putPenDown();
		return 1;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return PENDOWN;
	}

}
