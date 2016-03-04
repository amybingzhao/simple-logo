package Model;

import java.lang.reflect.InvocationTargetException;

/**
 * Cosine function.
 * Created by blakekaplan on 2/27/16.
 */
public class Cosine extends Node {

    private static final String COSINE = "cos ";
    private static final int DEGREES_PER_PI = 180;

    /**
     * Returns the cosine of the expression, where the expression is given in degrees.
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     */
    @Override
    public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        double degrees = getChildren().get(0).interpret();
        double radians = degrees * (Math.PI / DEGREES_PER_PI);
        return Math.cos(radians);
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return COSINE + getChildren().get(0).toString();
    }
}
