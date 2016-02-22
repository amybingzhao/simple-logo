package Functions;

import Controller.Parser;

/**
 * Abstract base class for all functions that manipulate a turtle.
 * @author amyzhao
 */

public interface TurtleFunction extends Function {
	
	/**
	 * Moves the turtle to location (x, y).
	 * @param x
	 * @param y
	 */
	public void moveTurtle(int x, int y);
	
	/**
	 * Rotates the turtle CW by the number of degrees specified by the argument.
	 * @param angle: number of degrees CW to rotate the turtle.
	 */
	public void rotateTurtle(double angle);

}
