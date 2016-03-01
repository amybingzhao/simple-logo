package Model;

/**
 * ShowTurtle function.
 * @author amyzhao
 *
 */
public class ShowTurtle extends Node {

	private static final String SHOWTURTLE = "showturtle ";
	
	/**
	 * Sets the turtle to visible and returns 1.
	 */
	@Override
	public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		Turtle turtle = getTurtle();
		turtle.show();;
		return 1;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return SHOWTURTLE;
	}

}
