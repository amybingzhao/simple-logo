package model;

import java.util.List;

/**
 * And function.
 *
 * @author amyzhao
 */
public class And extends Node {

    private static final String AND = "and ";
    private static final int EXPR1 = 0;
    private static final int EXPR2 = 1;

    /**
     * If expr1 and expr2 are both true, returns 1; else return 0.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<Node> children = getChildren();
        for (int i = 0; i < children.size(); i++) {
        	if (children.get(i).interpret(commandDict, varDict) == 0) {
        		return 0;
        	}
        }
        return 1;
    }

    /**
     * Returns the required user input for this command.
     */
    public String toString() {
        return AND + childrenToString();
    }

}
