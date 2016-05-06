/**
 * Modified for VOOGASalad addition
 */
package guipackage;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Animation.Status;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import model.Turtle;

public class CanvasAnimation {
	private static final int TURTLE_SIZE = 20;
	private static final int CENTER_FACTOR = TURTLE_SIZE/2;
	private static final double FLOAT_MARGIN_OF_ERROR = 0.01;
	private static final double ANIMATION_THRESHOLD = 0.5;
	private static final int DEFAULT_ROTATE_SPEED = 1000;
	private static final int DEFAULT_PATH_SPEED = 15;
	private Queue<Animation> myAnimationQueue;
	private Animation myAnimation;
	private double pathSpeed;
	private double rotateSpeed;
	private boolean willAnimate;
	
	public CanvasAnimation() {
		myAnimation = new SequentialTransition();
		myAnimationQueue = new LinkedList<>();
		pathSpeed = DEFAULT_PATH_SPEED;
		rotateSpeed = DEFAULT_ROTATE_SPEED;
		willAnimate = true;
	}
	
	protected void runAnimation() {
		if (myAnimation.getStatus() == Status.STOPPED) {
			playNextAnimation();
		}
	}
	
	protected void addAnimation(Node agent, double oldX, double oldY,
			double x, double y, double direction) {
		SequentialTransition newAnimation = new SequentialTransition();
		
		Path path = new Path();
		path.getElements().addAll(new MoveTo(oldX, oldY), new LineTo(x, y));
		if (Math.abs(oldX - x) > FLOAT_MARGIN_OF_ERROR || Math.abs(oldY - y) > FLOAT_MARGIN_OF_ERROR) {
			PathTransition pt = new PathTransition(Duration.millis(pathSpeed), path, agent);
			newAnimation.getChildren().add(pt);
		}
		
		if (Math.abs(direction) > FLOAT_MARGIN_OF_ERROR) {
			RotateTransition rt = new RotateTransition(Duration.millis(rotateSpeed), agent);
			rt.setByAngle((int) direction);
			newAnimation.getChildren().add(rt);
		}
		newAnimation.setOnFinished(event -> playNextAnimation());
		myAnimationQueue.add(newAnimation);
		runAnimation();
	}
	
	protected void playNextAnimation() {
		if (!myAnimationQueue.isEmpty()) {
			myAnimation = myAnimationQueue.poll();
			play();
		}
	}
	
	protected void setSpeed(double multiplier) {
		if (multiplier <= ANIMATION_THRESHOLD) {
			willAnimate = false;
		} else {
			willAnimate = true;
			pathSpeed = DEFAULT_PATH_SPEED * multiplier;
			rotateSpeed = DEFAULT_ROTATE_SPEED * multiplier;
		}
	}
	
	protected void play() {
		myAnimation.play();
	}
	
	protected boolean willAnimate() {
		return willAnimate;
	}

	/**
	 * Checks to see if the user wants to 
	 * @param turtle
	 * @param myX
	 * @param myY
	 */
	protected void checkForAnimation(Turtle turtle, double myX, double myY, List<Double[]> turtleParameters, CanvasImageManager myImageManager) {
		Double[] parameters = turtleParameters.get((int) turtle.getID() - 1);
		ImageView currentImageView = turtle.getImageView();
		if (willAnimate) {
			addAnimation(currentImageView, normalizeCoordinates(parameters[0]), 
					normalizeCoordinates(parameters[1]), normalizeCoordinates(myX),
					normalizeCoordinates(myY), turtle.getDirection() - parameters[2]);
			myImageManager.updateImageViewLocation(turtle, myX, myY, turtle.getImage());
		} else myImageManager.updateImageView(turtle, myX, myY, turtle.getDirection(), turtle.getImage());
	}
	
	/**
	 * Normalizes the coordinates to the center of the node.
	 * @param coordinate
	 * @return
	 */
	private double normalizeCoordinates(double coordinate) {
		return coordinate + CENTER_FACTOR;
	}
}
