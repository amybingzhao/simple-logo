package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Pi extends Node {

    private static final String PI = "pi ";

    /**
     * Returns the value of pi.
     */
    @Override
    public double interpret() {
        return Math.PI;
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return PI;
    }
}
