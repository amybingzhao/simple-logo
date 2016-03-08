package model;

import java.util.List;

/**
 * Difference function.
 * Created by blakekaplan on 2/27/16.
 */
public class Difference extends Node {

    private static final String DIFFERENCE = "difference ";
    private static final int START = 0;

    /**
     * Returns the difference between the two expressions.
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<IFunctions> children = getChildren();
        double diff = children.get(START).interpret(commandDict, varDict);
        for (int i = 1; i < children.size(); i++) {
        	diff = diff - children.get(i).interpret(commandDict, varDict);
        }
        return diff;
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return DIFFERENCE + childrenToString();
    }
}
