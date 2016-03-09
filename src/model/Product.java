package model;

import java.util.List;

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
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
    	List<IFunctions> children = getChildren();
		double prod = 1;
		for (int i = 0; i < children.size(); i++) {
			prod = prod * children.get(i).interpret(commandDict, varDict);
		}
		return prod;
    }
    
    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return PRODUCT + childrenToString();
    }
}
