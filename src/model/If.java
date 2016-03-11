package model;

/**
 * If function.
 *
 * @author amyzhao
 */
public class If extends IfNode {

    private static final String IF = "If ";
    
    /**
	 * Returns the class name and its children.
	 */
    @Override
    public String toString() {
        return IF + childrenToString();
    }

}
