package model;

import java.util.List;

/**
 * GreaterThan function.
 *
 * @author amyzhao
 */
public class GreaterThan extends BooleanNode {

    private static final String GREATER = "greater? ";
    private static final int EXPR1 = 0;
    private static final int EXPR2 = 1;

    /**
     * Returns 1 if expr1 is greater than expr2; 0 otherwise.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
	protected boolean checkCondition(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		return getChildren().get(EXPR1).interpret(commandDict, varDict) > getChildren().get(EXPR2).interpret(commandDict, varDict);
	}

    /**
     * Returns the required user input for this command.
     */
    public String toString() {
        return GREATER + childrenToString();
    }

}
