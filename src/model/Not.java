package model;

/**
 * Not function.
 *
 * @author amyzhao
 */
public class Not extends BooleanNode {

    private static final String NOT = "Not ";
    private static final int EXPR = 0;

    /**
     * If the given expression is false, return 1; else return 0.
     *  @param commandDict
     * @param varDict
     */
    @Override
    protected boolean checkCondition(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
   		return getChildren().get(EXPR).interpret(commandDict, varDict) == 0;
   	}

    /**
     * Returns the required user input for this command.
     */
    public String toString() {
        return NOT + childrenToString();
    }

}
