package model;

/**
 * And function.
 *
 * @author amyzhao
 */
public class And extends BooleanNode {

    private static final String AND = "And ";

    /**
     * If all expressions are true, returns true.
     *
     * @param commandDict
     * @param varDict
     * @throws IndexOutOfBoundsException
     * @throws NullPointerException 
     * @throws ClassNotFoundException 
     */
    @Override
	protected boolean checkCondition(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
		return countNumTrue(commandDict, varDict) == getChildren().size();
	}

    /**
     * Returns the required user input for this command.
     */
    public String toString() {
        return AND + childrenToString();
    }


}
