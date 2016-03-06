package model;

import java.util.List;

/**
 * Dotimes function.
 *
 * @author amyzhao
 */
public class DoTimes extends Node {

    private static final String DOTIMES = "dotimes ";
    private static final int VARIABLE_AND_LIMIT = 0;
    private static final int COMMANDS = 1;

    /**
     * Executes the given command the given number of times.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<Node> children = getChildren();
        Node iterVar = children.get(VARIABLE_AND_LIMIT);
        String var = iterVar.getChildren().get(0).toString(); // first child in command list should be varaible;
        double limit = iterVar.getChildren().get(1).interpret(commandDict, varDict); // second child is limit
        double ret = 0;

        // spec said to go from 1:limit
        for (double i = 1; i < limit; i++) {
            varDict.makeVariable(var, i);
            ret = children.get(COMMANDS).interpret(commandDict, varDict);
        }

        return ret;
    }

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        return DOTIMES + childrenToString();
    }

}
