package Model;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Power function.
 * Created by blakekaplan on 2/27/16.
 */
public class Power extends Node {

	private static final String POWER = "pow ";
	private static final int BASE = 0;
	private static final int EXPONENT = 1;
	
	/**
     * Raises the given base to the given exponent.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
     */
    @Override
    public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Node> children = getChildren();
        return Math.pow(children.get(BASE).interpret(), children.get(EXPONENT).interpret());
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return POWER + getChildren().get(BASE).toString() + " " +getChildren().get(EXPONENT).toString();
    }
}
