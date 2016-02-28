package Model;

public class YCoordinate extends Node {

	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		return turtle.getCurY();
	}

	@Override
	public String toString() {
		return "YCor";
	}

}
