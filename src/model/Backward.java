package model;

import java.util.List;

/**
 * Backward function.
 * @author amyzhao
 *
 */
public class Backward extends TurtleNode {

	private static final String BACKWARD = "Backward ";

	/**
	 * Moves the turtle backwards a given distance and returns the distance moved.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<IFunctions> children = getChildren();
		double dist = 0;
		for (int i = 0; i < children.size(); i++) {
			dist = turtle.move(-1 * children.get(i).interpret(commandDict, varDict));
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