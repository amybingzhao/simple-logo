package model;

import java.util.List;

/**
 * NotEqual function.
 *
 * @author amyzhao
 */
public class NotEqual extends Node {

    private static final String NOTEQUAL = "notequal? ";
    private static final int EXPR = 0;

    /**
     * If the expr1 and expr2 are not equal, returns 1; else 0.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
    	List<Node> children = getChildren();
		double expr = children.get(EXPR).interpret(commandDict, varDict);
		for (int i = 1; i < children.size(); i++) {
			if (children.get(i).interpret(commandDict, varDict) != expr) {
				return 1;
			}
		}
		return 0;
    }

    /**
     * Returns the required user input for this command.
     */
    public String toString() {
        return NOTEQUAL + childrenToString();
    }
}
