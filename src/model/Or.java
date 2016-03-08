package model;

/**
 * Or function.
 * @author amyzhao
 *
 */
public class Or extends BooleanNode {

	private static final String OR = "or ";
	
	/**
	 * If expr1 or expr2 is true, returns 1; else 0.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected boolean checkCondition(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		return countNumTrue(commandDict, varDict) > 0;
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	public String toString() {
		return OR + childrenToString();
	}

	
}
