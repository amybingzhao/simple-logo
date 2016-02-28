package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Tangent extends Node {

    public static final String TANGENT = "tan ";
    private static final int DEGREES = 0;

    @Override
    public double interpret() {
        double degrees = getChildren().get(DEGREES).interpret();
        double radians = degrees * (Math.PI / 180);
        return Math.tan(radians);
    }

    @Override
    public String toString() {
        return TANGENT + getChildren().get(DEGREES).toString();
    }
}
