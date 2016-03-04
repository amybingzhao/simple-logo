package Model;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Sum function.
 * @author amyzhao
 *
 */
public class Sum extends Node{
	
	private static final String SUM = "sum ";
	private static final int EXPR1 = 0;
	private static final int EXPR2 = 1;
	
	/**
	 * Returns the sum of expr1 and expr2.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	@Override
	public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<Node> children = getChildren();
		return children.get(EXPR1).interpret() + children.get(EXPR2).interpret();
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	public String toString() {
		List<Node> children = getChildren();
		return SUM + children.get(EXPR1).toString() + " " + children.get(EXPR2).toString();
	}
}
