package Model;

import java.util.List;

/**
 * IsPenDown function.
 * @author amyzhao
 *
 */
public class IsPenDown extends Node {

	private static final String PENDOWNP = "pendown? ";
	
	/**
	 * If the turtle's pen is down, returns 1; else returns 0.
	 */
	@Override
	public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> turtles = getActiveTurtles();
		double ret = 0;
		for (int i = 0; i < turtles.size(); i++) {
			if (turtles.get(i).penUp()) {
				ret = 0;
			} else {
				ret = 1;
			}
		}
		return ret;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return PENDOWNP;
	}
}
