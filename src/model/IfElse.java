package model;

import java.util.List;

/**
 * IfElse function.
 *
 * @author amyzhao
 */
public class IfElse extends ControlNode {

    private static final String IFELSE = "ifelse ";
    private static final int EXPR = 0;
    private static final int TRUE_COMMANDS = 1;
    private static final int FALSE_COMMANDS = 2;

    /**
     * If the given expression is true, executes the true commands; else executes the false commands.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<Node> children = getChildren();
        if (expressionIsTrue(children.get(EXPR).interpret(commandDict, varDict))) {
            return children.get(TRUE_COMMANDS).interpret(commandDict, varDict);
        } else {
           return children.get(FALSE_COMMANDS).interpret(commandDict, varDict);
        }
    }

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        return IFELSE + childrenToString();
    }

}
