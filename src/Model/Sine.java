package Model;

/**
 * Sine function.
 * Created by blakekaplan on 2/27/16.
 */
public class Sine extends Node {

    private static final String SINE = "sin ";
    private static final int DEGREES = 0;
    private static final int DEGREES_PER_PI = 180;

    /**
     * Returns the sine of the expression, where the expression is given in degrees.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        double degrees = getChildren().get(DEGREES).interpret(commandDict, varDict);
        double radians = degrees * (Math.PI / DEGREES_PER_PI);
        return Math.sin(radians);
    }

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        return SINE + getChildren().get(DEGREES).toString();
    }
}
