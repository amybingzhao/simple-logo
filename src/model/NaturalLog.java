package model;

/**
 * NaturalLog function.
 * Created by blakekaplan on 2/27/16.
 */
public class NaturalLog extends Node {

    private static final String NATURAL_LOG = "NaturalLog ";
    private static final int EXPR = 0;

    /**
     * Evaluates the natural logarithm of the given expression.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        return Math.log(getChildren().get(EXPR).interpret(commandDict, varDict));
    }

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        return NATURAL_LOG + childrenToString();
    }
}
