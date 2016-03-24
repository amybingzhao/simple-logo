package model;

/**
 * Pi function.
 * Created by blakekaplan on 2/27/16.
 */
public class Pi extends TreeNode {

    private static final String PI = "Pi ";

    /**
     * Returns the value of pi.
     * @param commandDict: command dictionary for current workspace.
     * @param varDict: variable dictionary for current workspace.
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
        return Math.PI;
    }

    /**
	 * Returns the class name.
	 */
    @Override
    public String toString() {
        return PI;
    }
}
