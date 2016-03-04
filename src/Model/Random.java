package Model;

import java.lang.reflect.InvocationTargetException;

/**
 * Random number function.
 * Created by blakekaplan on 2/27/16.
 */
public class Random extends Node {

    private static final String RANDOM = "random ";
    private static final int MAX = 0;

    /**
     * Returns a random value between 0 and the given max.
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     */
    @Override
    public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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
