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
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
		Turtle turtle = getTurtle();
		return turtle.turnTowards(children.get(X).interpret(commandDict, varDict), children.get(Y).interpret(commandDict, varDict));
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
