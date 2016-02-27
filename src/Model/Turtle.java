package Model;

import java.util.Observable;

import javafx.scene.image.Image;

/**
 * This class is the main component of the model. It records the current state of a Turtle and updates the view via the
 * Observer pattern. 
 * @author amyzhao
 *
 */

public class Turtle extends Observable {
	private Image myImage;
	private int myVariableName;
	private double myX;
	private double myY;
	private boolean penUp;
	private boolean isVisible;
	private double myDirection;
	private static final double ONE_REVOLUTION = 360;
	private static final double INCREMENT = 0.01;
	public Turtle() {
		myX = 0;
		myY = 0;
		penUp = true;
		isVisible = true;
		myDirection = 0;
	}
	
	/**
	 * Moves the turtle the specified distance in its current direction in increments of (1,1).
	 * @param dist: distance to move.
	 */
	public void move(double dist) {
		for (double i = 0; i < dist; i = i + INCREMENT) {
			myX = myX + INCREMENT * Math.sin(Math.toRadians(myDirection));
			myY = myY + INCREMENT * Math.cos(Math.toRadians(myDirection));
		}
	}
	
	/**
	 * Turns the turtle towards a given (x, y)
	 * @param x
	 * @param y
	 */
	public double turnTowards(double x, double y) {
		double angle = Math.toDegrees(Math.atan2(x, y));
		double angleDiff = angle - myDirection;
		setDirection(angle);
		return angleDiff;
	}
	
	/**
	 * Determines distance between current position and specified (x, y)
	 * @param x: x-coordinate of position of interest
	 * @param y: y-coordinate of position of interest
	 * @return distance between current position and (x, y)
	 */
	public double calcDistance(double x, double y) {
		return Math.sqrt(Math.pow(myX - x, 2) + Math.pow(myY - y, 2));
	}
	
	public void setDirection(double dir) {
		if (dir > ONE_REVOLUTION) {
			dir = dir % ONE_REVOLUTION;
		} else if (dir < 0) {
			dir = dir + ONE_REVOLUTION;
		} 
		
		myDirection = dir;
	}
	
	/**
	 * Lifts the turtle's pen up so no trail is drawn when it moves.
	 */
	public void penUp() {
		penUp = true;
	}
	
	/**
	 * Puts the turtle's pen down so a trail is drawn when it moves.
	 */
	public void penDown() {
		penUp = false;
	}
	
	/**
	 * Makes the turtle invisible.
	 */
	public void hide() {
		isVisible = false;
	}
	
	/**
	 * Makes the turtle visible.
	 */
	public void show() {
		isVisible = true;
	}
	
	public double getDirection() {
		return myDirection;
	}
	
	public double getCurX() {
		return myX;
	}
	
	public double getCurY() {
		return myY;
	}
	
	public String printPosition() {
		return ("(" + Double.toString(myX) + ", " + Double.toString(myY) + "), Direction: " + Double.toString(myDirection));
	}
}
