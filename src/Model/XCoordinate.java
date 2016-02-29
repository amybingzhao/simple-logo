package Model;

public class XCoordinate extends Node {

	private static final String XCOR = "xcor ";
	
	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		return turtle.getCurX();
	}

	@Override
	public String toString() {
		return XCOR;
	}

}
