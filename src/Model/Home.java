package Model;

/**
 * Home function.
 * @author amyzhao
 *
 */
public class Home extends Node {

	private static final String HOME = "home ";
	
	/**
	 * Moves the turtle back to the origin and returns the distance moved.
	 */
	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		return turtle.moveToHome();
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return HOME;
	}

}
