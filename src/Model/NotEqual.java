package Model;

import java.util.List;

/**
 * NotEqual function.
 * @author amyzhao
 *
 */
public class NotEqual extends Node {

	private static final String NOTEQUAL = "notequal? ";
	private static final int EXPR1 = 0;
	private static final int EXPR2 = 1;
	
	/**
	 * If the expr1 and expr2 are not equal, returns 1; else 0.
	 */
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		if (children.get(EXPR1).interpret() != children.get(EXPR2).interpret()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	public String toString() {
		List<Node> children = getChildren();
		return NOTEQUAL + children.get(EXPR1).toString() + " " + children.get(EXPR2).toString();
	}
}
