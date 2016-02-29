package Model;

public class HideTurtle extends Node {

	private static final String HIDETURTLE = "hideturtle ";
	
	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		turtle.hide();
		return 0;
	}

	@Override
	public String toString() {
		return HIDETURTLE;
	}
}
