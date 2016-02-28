package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Pi extends Node {

    private static final String PI = "pi ";

    @Override
    public double interpret() {
        return Math.PI;
    }

    @Override
    public String toString() {
        return PI;
    }
}
