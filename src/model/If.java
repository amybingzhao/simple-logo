package model;

import java.util.List;

/**
 * If function.
 *
 * @author amyzhao
 */
public class If extends ControlNode {

    private static final String IF = "if ";

    /**
     * Executes the given command if the given expression is true.
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
        return IF + childrenToString();
    }

}
