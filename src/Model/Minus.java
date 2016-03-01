package Model;

/**
 * Minus function.
 * Created by blakekaplan on 2/27/16.
 */
public class Minus extends Node {

    private static final String MINUS = "minus ";
    private static final int EXPR = 0;

    /**
     * Negates the given expression.
     */
    @Override
    public double interpret() throws ClassNotFoundException {
        return -1 * getChildren().get(EXPR).interpret();
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return MINUS + getChildren().get(EXPR).toString();
    }
}
