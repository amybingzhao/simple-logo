package Model;

import java.util.List;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Quotient extends Node {

    private static final String QUOTIENT = "quotient ";
    private static final int EXPR1 = 0;
	private static final int EXPR2 = 1;

	/**
	 * Returns the quotient of expr1 divided by expr2.
	 */
    @Override
    public double interpret() {
        List<Node> children = getChildren();
        return children.get(EXPR1).interpret() / children.get(EXPR2).interpret();
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return QUOTIENT + getChildren().get(EXPR1).toString() + " " + getChildren().get(EXPR2).toString();
    }
}
