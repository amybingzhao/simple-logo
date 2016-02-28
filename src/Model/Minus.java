package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Minus extends Node {

    public static final String MINUS = "Minus ";
    private static final int EXPR = 0;

    @Override
    public double interpret() {
        return -1 * getChildren().get(EXPR).interpret();
    }

    @Override
    public String toString() {
        return MINUS + getChildren().get(EXPR).toString();
    }
}
