package Model;

/**
 * PenUp function.
 * @author amyzhao
 *
 */
public class PenUp extends Node {

	private static final String PENUP = "penup ";
	
	/**
	 * Lifts pen up for current turtle so trail will no longer show.
	 */
	@Override
	public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
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
