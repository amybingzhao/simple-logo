package model;

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
		double dist = applyChildren(0, commandDict, varDict);
		return turtle.move(-dist);
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return BACKWARD + childrenToString();
	}
}