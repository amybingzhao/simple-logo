package Model;

public class YCoordinate extends Node {

	private static final String YCOR = "ycor ";
	
	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		return turtle.getCurY();
	}

	@Override
	public String toString() {
		return YCOR;
	}

}
