package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Pi extends Node {

    public static final String PI = "Pi";

    @Override
    public double interpret() {
        return Math.PI;
    }

    @Override
    public String toString() {
        return PI;
    }
}
