package Model;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Forward function.
 * @author amyzhao
 *
 */
public class Forward extends Node {

	private static final String FORWARD = "forward ";
	private static final int DISTANCE = 0;
	
	/**
     * Moves the turtle forward the given distance.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
     */
    @Override
    public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<Turtle> turtles = getTurtles();
        List<Node> children = getChildren();
        double dist = children.get(DISTANCE).interpret();
        
        for (int i = 0; i < turtles.size(); i++) {
        	if (turtles.get(i) != null) {
        		turtles.get(i).move(dist);
        	}
        }
        
        return dist;
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        List<Node> children = getChildren();
        return FORWARD + children.get(DISTANCE).toString();
    }
}