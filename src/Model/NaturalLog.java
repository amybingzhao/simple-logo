package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class NaturalLog extends Node {

    private static final String NATURAL_LOG = "log ";
    private static final int EXPR = 0;

    @Override
    public double interpret() {
        return Math.log(getChildren().get(EXPR).interpret());
    }

    @Override
    public String toString() {
        return NATURAL_LOG + getChildren().get(EXPR).toString();
    }
}
