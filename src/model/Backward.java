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
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
		double dist = applyChildren(0, commandDict, varDict);
		return turtle.move(-dist);
	}
	
	/**
	 * Returns the class name and its children.
	 */
	@Override
	public String toString() {
		return BACKWARD + childrenToString();
	}
}