package Model;

import java.util.List;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Difference extends Node {
    @Override
    public double interpret() {
        List<Node> children = getChildren();

        return children.get(0).interpret() - children.get(1).interpret();
    }

    @Override
    public String toString() {
        return "Difference " + getChildren().get(0).toString() + " " + getChildren().get(1).toString();
    }
}
