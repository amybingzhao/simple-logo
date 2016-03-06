package Model;

import java.util.Observable;

import javafx.scene.image.Image;

/**
 * This class is the main component of the model. It records the current state of a Turtle and updates the view via the
 * Observer pattern.
 *
 * @author amyzhao
 */

public class Turtle extends Observable {
    private Image myImage;
    private double myID;
    private double myX;
    private double myY;
    private boolean penUp;
    private boolean isVisible;
    private double myDirection;
    private boolean isActive;
    private boolean isCurrentTurtle;
    private boolean reset;
    private static final double ONE_REVOLUTION = 360;
    private static final double INCREMENT = 0.1;

    public Turtle(double ID) {
        myID = ID;
        myX = 0;
        myY = 0;
        penUp = true;
        isVisible = true;
        myDirection = 0;
        isCurrentTurtle = false;
    }

    /**
     * Moves the turtle the specified distance in its current direction in increments of (1,1).
     *
     * @param dist: distance to move.
     */
    public void move(double dist) {
        double limit = Math.abs(dist);
        double inc = INCREMENT;
        if (dist < 0) {
            inc = -inc;
        }

        for (double i = 0; i < limit; i = i + INCREMENT) {
            myX = myX + inc * Math.sin(Math.toRadians(myDirection));
            myY = myY + inc * Math.cos(Math.toRadians(myDirection));
            updateObservers();
        }
    }

    /**
     * Turns the turtle towards a given (x, y)
     *
     * @param x
     * @param y
     */
    public double turnTowards(double x, double y) {
        double angle = Math.toDegrees(Math.atan2(x - myX, y - myY));
        setDirection(angle);
        return angle;
    }

    public void setAsCurrentTurtle() {
        isCurrentTurtle = true;
    }

    public void noLongerCurrentTurtle() {
        isCurrentTurtle = false;
    }

    public boolean isCurrentTurtle() {
        return isCurrentTurtle;
    }

    /**
     * Determines distance between current position and specified (x, y)
     *
     * @param x: x-coordinate of position of interest
     * @param y: y-coordinate of position of interest
     * @return distance between current position and (x, y)
     */
    public double calcDistance(double x, double y) {
        return Math.sqrt(Math.pow(myX - x, 2) + Math.pow(myY - y, 2));
    }

    /**
     * Sets the direction the turtle is facing.
     *
     * @param dir: the direction the turtle should face in degrees.
     */
    public void setDirection(double dir) {
        if (dir > ONE_REVOLUTION) {
            dir = dir % ONE_REVOLUTION;
        } else if (dir < 0) {
            dir = dir + ONE_REVOLUTION;
        }

        myDirection = dir;
        updateObservers();
    }

    /**
     * Lets the observers know that the turtle has changed.
     */
    public void updateObservers() {
        setChanged();
        notifyObservers();
    }

    /**
     * Lifts the turtle's pen up so no trail is drawn when it moves.
     */
    public void liftPenUp() {
        penUp = true;
    }

    /**
     * Puts the turtle's pen down so a trail is drawn when it moves.
     */
    public void putPenDown() {
        penUp = false;
    }

    /**
     * Makes the turtle invisible.
     */
    public void hide() {
        isVisible = false;
        updateObservers();
    }

    /**
     * Checks if the pen is up.
     *
     * @return true if penUp is true; false otherwise.
     */
    public boolean isPenUp() {
        return penUp;
    }

    /**
     * Resets the Canvas.
     */
    public void resetTurtle() {
        reset = true;
        setChanged();
        updateObservers();
    }

    /**
     * Checks if turtle wants to be reset
     *
     * @return true if reset is true; false otherwise.
     */
    public boolean shouldReset() {
        return reset;
    }

    /**
     * Moves the turtle to home (0, 0).
     *
     * @return distance moved to get back home.
     */
    public double moveToHome() {
        double dist = calcDistance(0, 0);
        turnTowards(0, 0);
        move(dist);
        setDirection(0);
        return dist;
    }

    /**
     * Makes the turtle visible.
     */
    public void show() {
        isVisible = true;
        updateObservers();
    }

    /**
     * Checks if the turtle is visible.
     *
     * @return true if the turtle's isVisible field is true; false otherwise.
     */
    public boolean showing() {
        return isVisible;
    }

    /**
     * Checks the turtle's current direction.
     *
     * @return the turtle's current direction in degrees.
     */
    public double getDirection() {
        return myDirection;
    }

    /**
     * Checks the turtle's current x-coordinate.
     *
     * @return the turtle's current x-coordinate.
     */
    public double getCurX() {
        return myX;
    }

    /**
     * Checks the turtle's current y-coordinate.
     *
     * @return the turtle's current y-coordinate.
     */
    public double getCurY() {
        return myY;
    }

    public void activate() {
        isActive = true;
    }

    public void inactivate() {
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getID() {
        return myID;
    }

    /**
     * Prints the turtle's current position and direction.
     *
     * @return a string representing the turtle's current (x, y) position and direction.
     */
    public String printPosition() {
        return ("(" + Double.toString(myX) + ", " + Double.toString(myY) + "), Direction: " + Double.toString(myDirection));
    }

    public Image getImage() {
        return myImage;
    }
}
