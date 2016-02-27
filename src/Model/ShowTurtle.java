package Model;

public class ShowTurtle extends Node {

	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		turtle.show();;
		return 1;
	}

	@Override
	public String toString() {
		return "ShowTurtle";
	}

}
