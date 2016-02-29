package Model;

public class PenUp extends Node {

	private static final String PENUP = "penup ";
	
	/**
	 * Lifts pen up for current turtle.
	 */
	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		turtle.liftPenUp();
		return 0;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return PENUP;
	}

}
