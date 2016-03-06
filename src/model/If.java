package model;

import java.util.List;

/**
 * If function.
 *
 * @author amyzhao
 */
public class If extends Node {

    private static final String IF = "if ";
    private static final int EXPR = 0;
    private static final int COMMANDS = 1;

    /**
     * Executes the given command if the given expression is true.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<Node> children = getChildren();
        double ret = 0;

        if (children.get(EXPR).interpret(commandDict, varDict) == 1) {
            ret = children.get(COMMANDS).interpret(commandDict, varDict);
        }

        return ret;
    }

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        List<Node> children = getChildren();
        return "if " + children.get(EXPR).toString() + " " + children.get(COMMANDS).toString();
    }

}
