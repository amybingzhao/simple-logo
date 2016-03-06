package model;

import java.util.List;

/**
 * Not function.
 *
 * @author amyzhao
 */
public class Not extends Node {

    private static final String NOT = "not ";
    private static final int EXPR = 0;

    /**
     * If the given expression is false, return 1; else return 0.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<Node> children = getChildren();
        if (children.get(EXPR).interpret(commandDict, varDict) == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Returns the required user input for this command.
     */
    public String toString() {
        List<Node> children = getChildren();
        return NOT + children.get(EXPR).toString();
    }

}
