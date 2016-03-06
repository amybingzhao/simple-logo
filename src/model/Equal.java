package model;

import java.util.List;

/**
 * Equal function.
 * @author amyzhao
 *
 */
public class Equal extends Node {
	
	private static final String EQUAL = "equal? ";
	private static final int EXPR = 0;
	
	/**
	 * Returns 1 if the two expressions are equal; 0 otherwise.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
		double expr = children.get(EXPR).interpret(commandDict, varDict);
		for (int i = 1; i < children.size(); i++) {
			if (children.get(i).interpret(commandDict, varDict) != expr) {
				return 0;
			}
		}
		return 1;
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	public String toString() {
		return EQUAL + childrenToString();
	}
}
