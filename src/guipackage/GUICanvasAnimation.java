package guipackage;

import java.util.LinkedList;
import java.util.Queue;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Animation.Status;
import javafx.scene.Node;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class GUICanvasAnimation {
	private Queue<Animation> myAnimationQueue;
	private Animation myAnimation;
	
	public GUICanvasAnimation() {
		myAnimation = new SequentialTransition();
		myAnimationQueue = new LinkedList<Animation>();
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
		if (oldX != x || oldY != y) {
			PathTransition pt = new PathTransition(Duration.millis(1000), path, agent);
			newAnimation.getChildren().add(pt);
		}
		
		if (direction != 0) {
			RotateTransition rt = new RotateTransition(Duration.seconds(1), agent);
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
	
	protected void play() {
		myAnimation.play();
	}
	
	protected void pause() {
		myAnimation.pause();
	}
}
