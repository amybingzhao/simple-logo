package Model;

import java.util.List;

/**
 * PenUp function.
 * @author amyzhao
 *
 */
public class PenUp extends TurtleNode {

	private static final String PENUP = "penup ";

	/**
	 * Lifts pen up for current turtle so trail will no longer show.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> turtles = getActiveTurtles();
		for (int i = 0; i < turtles.size(); i++) {
			turtles.get(i).liftPenUp();
		}
		return 0;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return PENUP;
	}

}
