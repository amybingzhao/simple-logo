package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Random extends Node {

    private static final String RANDOM = "random ";
    private static final int MAX = 0;

    @Override
    public double interpret() {
        return Math.random() * getChildren().get(MAX).interpret();
    }

    @Override
    public String toString() {
        return RANDOM + getChildren().get(MAX).toString();
    }
}
