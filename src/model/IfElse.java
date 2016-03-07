package model;

import java.util.List;

/**
 * IfElse function.
 *
 * @author amyzhao
 */
public class IfElse extends ControlNode {

    private static final String IFELSE = "ifelse ";

    /**
     * If the given expression is true, executes the true commands; else executes the false commands.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        return ifStatement(getChildren().size(), commandDict, varDict);
    }

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        return IFELSE + childrenToString();
    }

}
