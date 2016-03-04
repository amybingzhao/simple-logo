package Model;

import java.util.List;

/**
 * Equal function.
 * @author amyzhao
 *
 */
public class Equal extends Node {
	
	private static final String EQUAL = "equal? ";
	private static final int EXPR1 = 0;
	private static final int EXPR2 = 0;
	
	/**
	 * Returns 1 if the two expressions are equal; 0 otherwise.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
		if (children.get(EXPR1).interpret(commandDict, varDict) == children.get(EXPR2).interpret(commandDict, varDict)) {
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
		return EQUAL + children.get(EXPR1).toString() + " " + children.get(EXPR2).toString();
	}
}
