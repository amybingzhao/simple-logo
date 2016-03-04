package Model;

import java.util.List;

/**
 * Heading function.
 * @author amyzhao
 *
 */
public class Heading extends Node {

	private static final String HEADING = "heading ";
	
	/**
	 * Returns the turtle's current direction.
	 */
	@Override
	public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> turtles = getTurtles();
		double dir = 0;
		for (int i = 0; i < turtles.size(); i++) {
			dir = turtles.get(i).getDirection();
		}
		
		return dir;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return HEADING;
	}

}
