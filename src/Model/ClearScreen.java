package Model;

import java.util.List;

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
	public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> turtles = getActiveTurtles();
		double dist = 0;
		for (int i = 0; i < turtles.size(); i++) {
			dist = turtles.get(i).moveToHome();
			turtles.get(i).resetTurtle();
		}
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
