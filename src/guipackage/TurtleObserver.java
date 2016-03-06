package guipackage;

import java.util.Observable;
import java.util.Observer;

import model.Turtle;

public class TurtleObserver implements Observer{
	private GUICanvas myCanvas;
	private double myX;
	private double myY;
	private double myDirection;
	private boolean penDown;
	private boolean isCurrentTurtle;
	private boolean isActive;
	private boolean reset;
	private boolean showing;
	private double myID;
	
	public TurtleObserver(GUICanvas canvas) {
		myCanvas = canvas;
	}

	@Override
	public void update(Observable o, Object arg) {
		Turtle turtle = (Turtle) o;
		myX = turtle.getCurX();
		myY = turtle.getCurY();
		myDirection = turtle.getDirection();
		penDown = !turtle.isPenUp();
		isActive = turtle.isActive();
		isCurrentTurtle = turtle.isCurrentTurtle();
		reset = turtle.shouldReset();
		showing = turtle.showing();
		updateCanvas();
	}
	
	public void updateCanvas() {
		myCanvas.update(this);
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
	
	protected boolean getPenDown() {
		return penDown;
	}

	public boolean isCurrentTurtle() {
		return isCurrentTurtle;
	}

	public boolean isActive() {
		return isActive;
	}

	public double getID() {
		return myID;
	}
	
	public boolean shouldReset() {
		return reset;
	}
	
	public boolean getShowing() {
		return showing;
	}
}
