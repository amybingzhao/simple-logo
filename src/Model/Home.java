package Model;

import java.util.List;

/**
 * Home function.
 * @author amyzhao
 *
 */
public class Home extends TurtleNode {

	private static final String HOME = "home ";

	/**
	 * Moves the turtle back to the origin and returns the distance moved.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		return turtle.moveToHome();
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return HOME;
	}
}
