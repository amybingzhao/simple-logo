package GUIPackage;

import Model.Turtle;
import java.util.Observable;
import java.util.Observer;

public class TurtleObserver implements Observer {
	private String myPosition;
	private int myDirection;

	@Override
	public void update(Observable o, Object arg) {
		Turtle turtle = (Turtle) o;
		myPosition = turtle.getPosition();
		myDirection = turtle.getDirection();
	}

}
