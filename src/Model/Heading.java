package Model;

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
		Turtle turtle = getTurtle();
		return turtle.getDirection();
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return HEADING;
	}

}
