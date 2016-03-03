package Model;

import java.util.List;

/**
 * Repeat function.
 *
 * @author amyzhao
 */
public class Repeat extends Node {

    private static final String REPEAT = "repeat ";
    private static final int EXPR = 0;
    private static final int COMMANDS = 1;
    private static final String REPCOUNT_VARIABLE = "repCount";

    /**
     * Repeats the given commands a given number of times.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<Node> children = getChildren();
        double numIter = children.get(EXPR).interpret(commandDict, varDict);
        double ret = 0;

        for (int i = 0; i < numIter; i++) {
            VariableDictionary.getInstance().makeVariable(REPCOUNT_VARIABLE, i);
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
        return REPEAT + children.get(EXPR).toString() + " " + children.get(COMMANDS).toString();
    }


}
