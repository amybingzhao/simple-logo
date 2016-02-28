package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class NaturalLog extends Node {

    public static final String NATURAL_LOG = "Natural Log ";

    @Override
    public double interpret() {
        return Math.log(getChildren().get(0).interpret());
    }

    @Override
    public String toString() {
        return NATURAL_LOG + getChildren().get(0).toString();
    }
}
