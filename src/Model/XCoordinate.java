package Model;

/**
 * XCoordinate function.
 * @author amyzhao
 *
 */
public class XCoordinate extends Node {

	private static final String XCOR = "xcor ";
	
	/**
	 * Returns the turtle's current x-coordinate.
	 */
	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		return turtle.getCurX();
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return XCOR;
	}
}
