package model;

/**
 * NotEqual function.
 *
 * @author amyzhao
 */
public class NotEqual extends BooleanNode {

    private static final String NOTEQUAL = "NotEqual ";
    private static final int EXPR = 0;

    /**
     * If the expr1 and expr2 are not equal, returns 1; else 0.
     *  @param commandDict
     * @param varDict
     */
    @Override
    protected boolean checkCondition(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		return countNumEqual(getChildren().get(EXPR).interpret(commandDict, varDict), commandDict, varDict) < getChildren().size();
	}

    /**
     * Returns the required user input for this command.
     */
    public String toString() {
        return NOTEQUAL + childrenToString();
    }
}
