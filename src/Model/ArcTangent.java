package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class ArcTangent extends Node {

    public static final String ARC_TANGENT = "ArcTangent ";

    @Override
    public double interpret() {
        double degrees = getChildren().get(0).interpret();
        double radians = degrees * (Math.PI / 180);
        return Math.atan(radians);
    }

    @Override
    public String toString() {
        return ARC_TANGENT + getChildren().get(0).toString();
    }
}
