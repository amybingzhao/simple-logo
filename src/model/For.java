package model;

import java.util.List;

/**
 * For function.
 * Created by blakekaplan on 2/25/16.
 */
public class For extends Node {

    private static final String FOR = "For ";
    private static final int VARIABLE_AND_LIMITS = 0;
    private static final int COMMANDS = 1;
    private static final int LOW = 1;
    private static final int HIGH = 2;
    private static final int INCR = 3;
    private static final int VAR = 0;

    /**
     * Repeats the given commands for the given start and end limits and the given increment.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<IFunctions> children = getChildren();
        CommandList argList = (CommandList) children.get(VARIABLE_AND_LIMITS);
        List<IFunctions> argsNodes = argList.getChildren();
        double low = argsNodes.get(LOW).interpret(commandDict, varDict);
        double high = argsNodes.get(HIGH).interpret(commandDict, varDict);
        double increment = argsNodes.get(INCR).interpret(commandDict, varDict);
        Variable myVar = (Variable) argsNodes.get(VAR);
        String varString = myVar.toString();

        double ret = 0;

        for (double i = low; i < high; i += increment) {
            varDict.makeVariable(varString, i);
            ret = children.get(COMMANDS).interpret(commandDict, varDict);
        }

        return ret;
    }

    /**
     * Returns the required user input for this command.
     */
    public String toString() {
        return FOR + childrenToString();
    }
}
