package Model;

import java.util.List;

/**
 * Forward function.
 *
 * @author amyzhao
 */
public class Forward extends TurtleNode {

	private static final String FORWARD = "forward ";
	private static final int DISTANCE = 0;

	/**
	 * Moves the turtle forward the given distance.
	 *
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
				turtles.get(i).move(dist);
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
			return FORWARD + children.get(DISTANCE).toString();
		}
	}