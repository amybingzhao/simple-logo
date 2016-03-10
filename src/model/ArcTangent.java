package model;

/**
 * ArcTangent function.
 * Created by blakekaplan on 2/27/16.
 */
public class ArcTangent extends Node {

    private static final String ARC_TANGENT = "ArcTangent ";	// is there a reason why this is public?
    private static final int DEGREES = 0;
    
    /**
     * Returns the arctangent of the expression, where the expression is given in degrees.
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
        return Math.atan(Math.toRadians(getChildren().get(DEGREES).interpret(commandDict, varDict)));
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return ARC_TANGENT + childrenToString();
    }
}
