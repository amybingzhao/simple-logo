package Model;

/**
 * Random number function.
 * Created by blakekaplan on 2/27/16.
 */
public class Random extends Node {

    private static final String RANDOM = "random ";
    private static final int MAX = 0;

    /**
     * Returns a random value between 0 and the given max.
     */
    @Override
    public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        return Math.random() * getChildren().get(MAX).interpret();
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return RANDOM + getChildren().get(MAX).toString();
    }
}
