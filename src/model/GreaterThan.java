package model;

import java.util.List;

/**
 * GreaterThan function.
 *
 * @author amyzhao
 */
public class GreaterThan extends Node {

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
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<Node> children = getChildren();
        if (children.get(EXPR1).interpret(commandDict, varDict) > children.get(EXPR2).interpret(commandDict, varDict)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Returns the required user input for this command.
     */
    public String toString() {
        return GREATER + childrenToString();
    }

}
