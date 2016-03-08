package model;

/**
 * If function.
 *
 * @author amyzhao
 */
public class If extends IfNode {

    private static final String IF = "if ";
    
    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        return IF + childrenToString();
    }

}
