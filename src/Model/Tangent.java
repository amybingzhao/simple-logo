package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Tangent extends Node {

    public static final String TANGENT = "Tangent ";

    @Override
    public double interpret() {
        double degrees = getChildren().get(0).interpret();
        double radians = degrees * (Math.PI / 180);
        return Math.tan(radians);
    }

    @Override
    public String toString() {
        return TANGENT + getChildren().get(0).toString();
    }
}
