package model;

/**
 * Difference function.
 * Created by blakekaplan on 2/27/16.
 */
public class Difference extends Node {

    private static final String DIFFERENCE = "Difference ";
    private static final int START = 0;

    /**
     * Returns the difference between the two expressions.
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        return applyChildren(getChildren().get(START).interpret(commandDict, varDict) * 2, commandDict, varDict);
    }
    
    @Override
    protected double addChildValue(double val, IFunctions child, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
    	return val - child.interpret(commandDict, varDict);
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return DIFFERENCE + childrenToString();
    }
}
