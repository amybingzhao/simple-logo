package model;

import java.util.List;

/**
 * Or function.
 * @author amyzhao
 *
 */
public class Or extends Node {

	private static final String OR = "or ";
	private static final int EXPR1 = 0;
	private static final int EXPR2 = 1;
	
	/**
	 * If expr1 or expr2 is true, returns 1; else 0.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
		if (children.get(EXPR1).interpret(commandDict, varDict) > 0 || children.get(EXPR2).interpret(commandDict, varDict) > 0) {
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
		return OR + children.get(EXPR1).toString() + " " + children.get(EXPR2).toString();
	}
	
}
