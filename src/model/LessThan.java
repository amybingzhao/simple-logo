package model;

import java.util.List;

/**
 * LessThan function.
 *
 * @author amyzhao
 */
public class LessThan extends Node {

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
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<Node> children = getChildren();
        if (children.get(EXPR1).interpret(commandDict, varDict) < children.get(EXPR2).interpret(commandDict, varDict)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Returns the required user input for this command.
     */
    public String toString() {
        return LESS + childrenToString();
    }

}
