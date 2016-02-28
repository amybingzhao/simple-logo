package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Minus extends Node {

    public static final String MINUS = "Minus ";

    @Override
    public double interpret() {
        return -1 * getChildren().get(0).interpret();
    }

    @Override
    public String toString() {
        return MINUS + getChildren().get(0).toString();
    }
}
