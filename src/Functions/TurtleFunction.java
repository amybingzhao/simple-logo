package Functions;

import Controller.Parser;

/**
 * Abstract base class for all functions that manipulate a turtle.
 * @author amyzhao
 */

public abstract class TurtleFunction extends Function {

	/**
	 * Constructs a TurtleFunction object with a reference to a parser.
	 * @param parser: parser for the function to use.
	 */
	public TurtleFunction(Parser parser) {
		super(parser);
	}
	
	/**
	 * Moves the turtle to location (x, y).
	 * @param x
	 * @param y
	 */
	protected void moveTurtle(int x, int y) {
	
	}
	
	/**
	 * Rotates the turtle CW by the number of degrees specified by the argument.
	 * @param angle: number of degrees CW to rotate the turtle.
	 */
	protected void rotateTurtle(double angle) {
		
	}

}
