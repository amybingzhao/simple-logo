package model;

import java.util.List;

/**
 * Sum function.
 * @author amyzhao
 *
 */
public class Sum extends Node{
	
	private static final String SUM = "Sum ";
	
	/**
	 * Returns the sum of expr1 and expr2.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<IFunctions> children = getChildren();
		double sum = 0;
		for (int i = 0; i < children.size(); i++) {
			sum += children.get(i).interpret(commandDict, varDict);
		}
		return sum;
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	public String toString() {
		return SUM + childrenToString();
	}
}
