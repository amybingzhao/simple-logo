package Model;

import java.util.List;

/**
 * If function.
 * @author amyzhao
 *
 */
public class If extends Node {

	private static final String IF = "if ";
	private static final int EXPR = 0;
	private static final int COMMANDS = 1;
	
	/**
	 * Executes the given command if the given expression is true.
	 */
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		double ret = 0;
		
		if (children.get(EXPR).interpret() == 1) {
			ret = children.get(COMMANDS).interpret();
		}
		
		return ret;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		List<Node> children = getChildren();
		return "if " + children.get(EXPR).toString() + " " + children.get(COMMANDS).toString();
	}

}
