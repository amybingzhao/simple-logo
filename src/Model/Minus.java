package Model;

import java.lang.reflect.InvocationTargetException;

/**
 * Minus function.
 * Created by blakekaplan on 2/27/16.
 */
public class Minus extends Node {

    private static final String MINUS = "minus ";
    private static final int EXPR = 0;

    /**
     * Negates the given expression.
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     */
    @Override
    public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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
