package Model;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Backward function.
 * @author amyzhao
 *
 */
public class Backward extends Node {

	private static final String BACKWARD = "back ";
	private static final int DISTANCE = 0;

	/**
	* Moves the turtle backwards a given distance and returns the distance moved.
	* @param commandDict
	* @param varDict
	*/
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Turtle> turtles = getActiveTurtles();
		List<Node> children = getChildren();

		double dist = children.get(DISTANCE).interpret(commandDict, varDict);

		for (int i = 0; i < turtles.size(); i++) {
			if (turtles.get(i) != null) {
				turtles.get(i).move(-dist);
			}
		}
		return dist;  
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		List<Node> children = getChildren();
		return BACKWARD + children.get(DISTANCE).toString();
	}
}