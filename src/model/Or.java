package model;

/**
 * Or function.
 * @author amyzhao
 *
 */
public class Or extends BooleanNode {

	private static final String OR = "Or ";
	
	/**
     * If any of the child expressions are true, returns 1; else 0.
     * @param commandDict
     * @param varDict
     */
	@Override
	protected boolean checkCondition(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		return countNumTrue(commandDict, varDict) > 0;
	}
	
	/**
	 * Returns the class name and its children.
	 */
	public String toString() {
		return OR + childrenToString();
	}

	
}
