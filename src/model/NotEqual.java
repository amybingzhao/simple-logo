package model;

import java.util.List;

/**
 * NotEqual function.
 *
 * @author amyzhao
 */
public class NotEqual extends Node {

    private static final String NOTEQUAL = "notequal? ";
    private static final int EXPR1 = 0;
    private static final int EXPR2 = 1;

    /**
     * If the expr1 and expr2 are not equal, returns 1; else 0.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<Node> children = getChildren();
        if (children.get(EXPR1).interpret(commandDict, varDict) != children.get(EXPR2).interpret(commandDict, varDict)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Returns the required user input for this command.
     */
    public String toString() {
        return NOTEQUAL + childrenToString();
    }
}
