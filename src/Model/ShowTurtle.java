package Model;

public class ShowTurtle extends Node {

	private static final String SHOWTURTLE = "showturtle ";
	
	@Override
	public double interpret() {
		Turtle turtle = getTurtle();
		turtle.show();;
		return 1;
	}

	@Override
	public String toString() {
		return SHOWTURTLE;
	}

}
