package model;

import java.util.List;

/**
 * For function.
 * Created by blakekaplan on 2/25/16.
 */
public class For extends Node {

    private static final String FOR = "for ";
    private static final int VARIABLE_AND_LIMITS = 0;
    private static final int COMMANDS = 1;

    /**
     * Repeats the given commands for the given start and end limits and the given increment.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<Node> children = getChildren();
        CommandList argList = (CommandList) children.get(VARIABLE_AND_LIMITS);
        List<Node> argsNodes = argList.getChildren();
        double low = argsNodes.get(1).interpret(commandDict, varDict);
        double high = argsNodes.get(2).interpret(commandDict, varDict);
        double increment = argsNodes.get(3).interpret(commandDict, varDict);
        Variable myVar = (Variable) argsNodes.get(0);
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
