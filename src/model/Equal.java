package model;

/**
 * Equal function.
 * @author amyzhao
 *
 */
public class Equal extends BooleanNode {
	
	private static final String EQUAL = "equal? ";
	private static final int EXPR = 0;
	
	/**
	 * Returns 1 if the two expressions are equal; 0 otherwise.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	protected boolean checkCondition(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		return countNumEqual(getChildren().get(EXPR).interpret(commandDict, varDict), commandDict, varDict) == getChildren().size();
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	public String toString() {
		return EQUAL + childrenToString();
	}
}
