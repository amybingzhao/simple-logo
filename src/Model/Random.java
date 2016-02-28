package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Random extends Node {

    public static final String RANDOM = "Random ";

    @Override
    public double interpret() {
        return Math.random() * getChildren().get(0).interpret();
    }

    @Override
    public String toString() {
        return RANDOM + getChildren().get(0).toString();
    }
}
