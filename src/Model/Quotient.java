package Model;

import java.util.List;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Quotient extends Node {

    public static final String QUOTIENT = "Quotient ";

    @Override
    public double interpret() {
        List<Node> children = getChildren();
        return children.get(0).interpret() / children.get(1).interpret();
    }

    @Override
    public String toString() {
        return QUOTIENT + getChildren().get(0).toString() + " " + getChildren().get(1).toString();
    }
}
