package Model;

import java.util.List;

/**
 * Sum function.
 * @author amyzhao
 *
 */
public class Sum extends Node{
	
	private static final String SUM = "sum ";
	private static final int EXPR1 = 0;
	private static final int EXPR2 = 1;
	
	/**
	 * Returns the sum of expr1 and expr2.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
		return children.get(EXPR1).interpret(commandDict, varDict) + children.get(EXPR2).interpret(commandDict, varDict);
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	public String toString() {
		List<Node> children = getChildren();
		return SUM + children.get(EXPR1).toString() + " " + children.get(EXPR2).toString();
	}
}
