package model;

import java.util.function.Predicate;

/**
 * IsShowing function.
 * @author amyzhao
 *
 */
public class IsShowing extends TurtleNode {

	private static final String SHOWINGP = "IsShowing ";

	/**
	 * Returns 1 if the turtle is showing on the canvas; 0 otherwise.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		Predicate<Turtle> show = t -> t.showing();
		return checkTurtleProperty(show, turtle);
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return SHOWINGP;
	}
}
