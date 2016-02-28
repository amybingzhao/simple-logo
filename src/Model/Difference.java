package Model;

import java.util.List;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Difference extends Node {

    private static final String DIFFERENCE = "difference ";
    private static final int EXPR1 = 0;
    private static final int EXPR2 = 1;

    @Override
    public double interpret() {
        List<Node> children = getChildren();

        return children.get(EXPR1).interpret() - children.get(EXPR2).interpret();
    }

    @Override
    public String toString() {
        return DIFFERENCE + getChildren().get(EXPR1).toString() + " " + getChildren().get(EXPR2	).toString();
    }
}
