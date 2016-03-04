package Model;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Equal function.
 * @author amyzhao
 *
 */
public class Equal extends Node {
	
	private static final String EQUAL = "equal? ";
	private static final int EXPR1 = 0;
	private static final int EXPR2 = 0;
	
	/**
	 * Returns 1 if the two expressions are equal; 0 otherwise.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Override
	public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<Node> children = getChildren();
		if (children.get(EXPR1).interpret() == children.get(EXPR2).interpret()) {
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
		return EQUAL + children.get(EXPR1).toString() + " " + children.get(EXPR2).toString();
	}
}
