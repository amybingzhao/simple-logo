package Model;

import java.util.List;

/**
 * Difference function.
 * Created by blakekaplan on 2/27/16.
 */
public class Difference extends Node {

    private static final String DIFFERENCE = "difference ";
    private static final int EXPR1 = 0;
    private static final int EXPR2 = 1;

    /**
     * Returns the difference between the two expressions.
     */
    @Override
    public double interpret() {
        List<Node> children = getChildren();

        return children.get(EXPR1).interpret() - children.get(EXPR2).interpret();
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return DIFFERENCE + getChildren().get(EXPR1).toString() + " " + getChildren().get(EXPR2	).toString();
    }
}
