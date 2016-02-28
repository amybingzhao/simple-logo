package Model;

public class XCoordinate extends Node {

	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		return turtle.getCurX();
	}

	@Override
	public String toString() {
		return "XCor";
	}

}
