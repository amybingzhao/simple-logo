package model;

/**
 * Minus function.
 * Created by blakekaplan on 2/27/16.
 */
public class Minus extends Node {

    private static final String MINUS = "Minus ";
    private static final int EXPR = 0;

    /**
     * Negates the given expression.
     *  @param commandDict
     * @param varDict*/
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
        return -1 * getChildren().get(EXPR).interpret(commandDict, varDict);
    }

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        return MINUS + childrenToString();
    }
}
