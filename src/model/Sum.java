package model;

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
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
		return applyChildren(0, commandDict, varDict);
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	public String toString() {
		return SUM + childrenToString();
	}
}
