package model;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Backward function.
 * @author amyzhao
 *
 */
public class Backward extends TurtleNode {

	private static final String BACKWARD = "back ";
	private static final int DISTANCE = 0;

	/**
	 * Moves the turtle backwards a given distance and returns the distance moved.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();

		double dist = children.get(DISTANCE).interpret(commandDict, varDict);
		if (turtle != null) {
			turtle.move(-dist);
		}

		return dist;
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return BACKWARD + childrenToString();
	}
}