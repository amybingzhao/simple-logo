package Model;

import java.util.List;

/**
 * SetTowards function.
 * @author amyzhao
 *
 */
public class SetTowards extends Node {

	private static final String TOWARDS = "towards ";
	private static final int X = 0;
	private static final int Y = 1;
	
	/**
	 * Turns the turtle to face the given (x, y) position.
	 */
	@Override
	public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
		List<Turtle> turtles = getActiveTurtles();
		double degree = 0;
		
		for (int i = 0; i < turtles.size(); i++) {
			degree = turtles.get(i).turnTowards(children.get(X).interpret(), children.get(Y).interpret());
		}
		
		return degree;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		List<Node> children = getChildren();
		return TOWARDS + children.get(X).toString() + " " + children.get(Y).toString();
	}
}
