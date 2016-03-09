package model;

import java.util.function.Predicate;

/**
 * IsPenDown function.
 * @author amyzhao
 *
 */
public class IsPenDown extends TurtleNode {

	private static final String PENDOWNP = "IsPenDown ";

	/**
	 * If the turtle's pen is down, returns 1; else returns 0.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		Predicate<Turtle> pen = t -> !t.isPenUp();
		return checkTurtleProperty(pen, turtle);
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return PENDOWNP;
	}	
}
