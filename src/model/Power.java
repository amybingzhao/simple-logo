package model;

import java.util.List;

/**
 * Power function.
 * Created by blakekaplan on 2/27/16.
 */
public class Power extends Node {

	private static final String POWER = "Power ";
	private static final int BASE = 0;
	private static final int EXPONENT = 1;
	
	/**
     * Raises the given base to the given exponent.
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
        List<IFunctions> children = getChildren();
        return Math.pow(children.get(BASE).interpret(commandDict, varDict), children.get(EXPONENT).interpret(commandDict, varDict));
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return POWER + childrenToString();
    }
}
