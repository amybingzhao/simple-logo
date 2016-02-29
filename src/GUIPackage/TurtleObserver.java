package GUIPackage;

import Model.Turtle;
import java.util.Observable;
import java.util.Observer;

public class TurtleObserver implements Observer {
	private double myX;
	private double myY;
	private double myDirection;
	private boolean penDown;

	@Override
	public void update(Observable o, Object arg) {
		Turtle turtle = (Turtle) o;
		myX = turtle.getCurX();
		myY = turtle.getCurY();
		myDirection = turtle.getDirection();
		System.out.println("hello");
	}
	
	protected double getX() {
		return myX;
	}
	
	protected double getY() {
		return myY;
	}
	
	protected double getDirection() {
		return myDirection;
	}

}
