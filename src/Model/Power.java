package Model;

import java.util.List;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Power extends Node {

    @Override
    public double interpret() {
        List<Node> children = getChildren();
        return Math.pow(children.get(0).interpret(), children.get(1).interpret());
    }

    @Override
    public String toString() {
        return "Power " + getChildren().get(0).toString() + " " +getChildren().get(1).toString();
    }
}
