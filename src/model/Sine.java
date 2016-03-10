package model;

/**
 * Sine function.
 * Created by blakekaplan on 2/27/16.
 */
public class Sine extends Node {

    private static final String SINE = "Sine ";
    private static final int DEGREES = 0;

    /**
     * Returns the sine of the expression, where the expression is given in degrees.
     *  @param commandDict
     * @param varDict*/
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
        return Math.sin(Math.toRadians(getChildren().get(DEGREES).interpret(commandDict, varDict)));
    }

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        return SINE + childrenToString();
    }
}
