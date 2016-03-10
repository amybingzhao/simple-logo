package model;

/**
 * Product function.
 * Created by blakekaplan on 2/27/16.
 */
public class Product extends Node {

    private static final String PRODUCT = "Product ";

	/**
     * Returns the product of expr1 and expr2.
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
        return applyChildren(1, commandDict, varDict);

    }
    
    @Override
    protected double addChildValue(double val, IFunctions child, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
    	return val * child.interpret(commandDict, varDict);
    }
    
    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return PRODUCT + childrenToString();
    }
}
