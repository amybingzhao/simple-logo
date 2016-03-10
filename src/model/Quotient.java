package model;

/**
 * Quotient function.
 * Created by blakekaplan on 2/27/16.
 */
public class Quotient extends Node {

    private static final String QUOTIENT = "Quotient ";

	/**
     * Returns the quotient of expr1 divided by expr2.
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
        return applyChildren(Math.pow(getChildren().get(0).interpret(commandDict, varDict), 2), commandDict, varDict);
    }

    @Override
    protected double addChildValue(double val, IFunctions child, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
        return val / child.interpret(commandDict, varDict);
    }
    
    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return QUOTIENT + childrenToString();
    }
}
