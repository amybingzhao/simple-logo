package model;

/**
 * Cosine function.
 * Created by blakekaplan on 2/27/16.
 */
public class Cosine extends Node {

    private static final String COSINE = "Cosine ";
    private static final int DEGREES = 0;

    /**
     * Returns the cosine of the expression, where the expression is given in degrees.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        return Math.cos(Math.toRadians(getChildren().get(DEGREES).interpret(commandDict, varDict)));
    }

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        return COSINE + childrenToString();
    }
}
