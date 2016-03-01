package Model;

/**
 * HideTurtle function.
 * @author amyzhao
 *
 */
public class HideTurtle extends Node {

	private static final String HIDETURTLE = "hideturtle ";
	
	/**
	 * Sets the turtle to invisible.
	 */
	@Override
	public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		Turtle turtle = getTurtle();
		turtle.hide();
		return 0;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return HIDETURTLE;
	}
}
