package GUIPackage;

import Model.Turtle;
import java.util.Observable;
import java.util.Observer;

public class TurtleObserver implements Observer {
	private int myX;
	private int myY;
	private int myDirection;
	private boolean penDown;

	@Override
	public void update(Observable o, Object arg) {
		Turtle turtle = (Turtle) o;
		myX = turtle.getCurX();
		myY = turtle.getCurY();
		myDirection = turtle.getDirection();
	}
	
	protected int getX() {
		return myX;
	}
	
	protected int getY() {
		return myY;
	}
	
	protected int getDirection() {
		return myDirection;
	}

}
