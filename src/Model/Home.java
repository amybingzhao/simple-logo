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
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> turtles = getActiveTurtles();
		double dist = 0;
		for (int i = 0; i < turtles.size(); i++) {
			dist = turtles.get(i).moveToHome();
		}
		return dist;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return HOME;
	}

}
