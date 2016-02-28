package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Sine extends Node {

    public static final String SINE = "Sine ";

    @Override
    public double interpret() {
        double degrees = getChildren().get(0).interpret();
        double radians = degrees * (Math.PI / 180);
        return Math.sin(radians);
    }

    @Override
    public String toString() {
        return SINE + getChildren().get(0).toString();
    }
}
