package model;

import java.util.List;

/**
 * SetTowards function.
 * @author amyzhao
 *
 */
public class SetTowards extends TurtleNode {

	private static final String TOWARDS = "towards ";
	private static final int X = 0;
	private static final int Y = 1;
	
	/**
	 * Turns the turtle to face the given (x, y) position.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
		return turtle.turnTowards(children.get(X).interpret(commandDict, varDict), children.get(Y).interpret(commandDict, varDict));
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return TOWARDS + childrenToString();
	}	
}
