package model;

import java.util.List;

/**
 * Quotient function.
 * Created by blakekaplan on 2/27/16.
 */
public class Quotient extends Node {

    private static final String QUOTIENT = "quotient ";

	/**
     * Returns the quotient of expr1 divided by expr2.
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
    	List<IFunctions> children = getChildren();
		double quotient = children.get(0).interpret(commandDict, varDict);
		for (int i = 1; i < children.size(); i++) {
			quotient = quotient/children.get(i).interpret(commandDict, varDict);
		}
		return quotient;
	}

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return QUOTIENT + childrenToString();
    }
}
