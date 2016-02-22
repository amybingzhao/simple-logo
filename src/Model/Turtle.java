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
	private int x;
	private int y;
	private boolean penUp;
	private boolean isVisible;
	private double myDirection;
	
	/**
	 * Moves the turtle towards the specified location in increments of (1,1).
	 * @param x: x-coordinate of location to move to.
	 * @param y: y-coordinate of location to move to.
	 */
	public void move(int x, int y) {
		
	}
	
	/**
	 * Lifts the turtle's pen up so no trail is drawn when it moves.
	 */
	public void penUp() {
		
	}
	
	/**
	 * Puts the turtle's pen down so a trail is drawn when it moves.
	 */
	public void penDown() {
		
	}
	
	/**
	 * Makes the turtle invisible.
	 */
	public void hide() {
		
	}
	
	/**
	 * Makes the turtle visible.
	 */
	public void show() {
		
	}
}
