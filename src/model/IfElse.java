package model;

/**
 * IfElse function.
 *
 * @author amyzhao
 */
public class IfElse extends IfNode {

    private static final String IFELSE = "ifelse ";

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        return IFELSE + childrenToString();
    }

}
