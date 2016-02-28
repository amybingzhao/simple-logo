package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Cosine extends Node {

    public static final String COSINE = "Cosine ";

    @Override
    public double interpret() {
        double degrees = getChildren().get(0).interpret();
        double radians = degrees * (Math.PI / 180);
        return Math.cos(radians);
    }

    @Override
    public String toString() {
        return COSINE + getChildren().get(0).toString();
    }
}
