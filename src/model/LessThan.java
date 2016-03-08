package model;

/**
 * LessThan function.
 *
 * @author amyzhao
 */
public class LessThan extends BooleanNode {

    private static final String LESS = "less? ";
    private static final int EXPR1 = 0;
    private static final int EXPR2 = 1;

    /**
     * If expr1 is less than expr2, returns 1; else returns 0.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
   	protected boolean checkCondition(CommandDictionary commandDict, VariableDictionary varDict)
   			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
   		return getChildren().get(EXPR1).interpret(commandDict, varDict) < getChildren().get(EXPR2).interpret(commandDict, varDict);
   	}

    /**
     * Returns the required user input for this command.
     */
    public String toString() {
        return LESS + childrenToString();
    }

}
