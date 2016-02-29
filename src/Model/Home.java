package Model;

public class Home extends Node {

	private static final String HOME = "home ";
	
	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		double dist = turtle.calcDistance(0, 0);
		turtle.turnTowards(0, 0);
		turtle.move(dist);
		return dist;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return HOME;
	}

}
