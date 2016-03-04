package Model;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Not function.
 * @author amyzhao
 *
 */
public class Not extends Node {

	private static final String NOT = "not ";
	private static final int EXPR = 0;
	
	/**
	 * If the given expression is false, return 1; else return 0.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Override
	public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<Node> children = getChildren();
		if (children.get(EXPR).interpret() == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	public String toString() {
		List<Node> children = getChildren();
		return NOT + children.get(EXPR).toString();
	}
	
}
