package Model;

import java.util.List;

/**
 * SetHeading function.
 * @author amyzhao
 *
 */
public class SetHeading extends Node {
	
	private static final String SETHEADING = "setheading ";
	private static final int DEGREES = 0;
	
	/**
	 * Turns the turtle towards to the given degrees, where 0 is facing north and rotating CW is positive.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
		Turtle turtle = getTurtle();
		double curDir = turtle.getDirection();
		
		turtle.setDirection(children.get(DEGREES).interpret(commandDict, varDict));

		return children.get(DEGREES).interpret(commandDict, varDict) - curDir;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		List<Node> children = getChildren();
		return SETHEADING + children.get(DEGREES).toString();
	}
}
