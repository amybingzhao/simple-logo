package Model;

/**
 * Clearscreen function.
 * @author amyzhao
 *
 */
public class ClearScreen extends Node {

	private static final String CLEARSCREEN = "clearscreen ";
	
	/** 
	 * Moves the turtle back to (0, 0) and erases its trails; returns the distance the turtle moved to get back to (0, 0).
	 */
	@Override
	public double interpret() throws ClassNotFoundException {
		Turtle turtle = getTurtle();
		double dist = turtle.moveToHome();
		//TODO: clear screen somehow
		return dist;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return CLEARSCREEN;
	}

}
