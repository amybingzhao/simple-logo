package guipackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Animation.Status;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class GUICanvasAnimation {
	private Queue<Animation> myAnimationQueue;
	private Animation myAnimation;
	private Pane myRoot;
	private Queue<Queue<Animation>> myLineAnimationQueue;
	private Queue<Animation> myLineAnimation;
	private boolean drawPen;
	
	public GUICanvasAnimation(Pane root) {
		myAnimation = new SequentialTransition();
		myAnimationQueue = new LinkedList<Animation>();
		myLineAnimation = new LinkedList<Animation>();
		myLineAnimationQueue = new LinkedList<Queue<Animation>>();
		myRoot = root;
		drawPen = true;
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
			PathTransition pt = new PathTransition(Duration.millis(100), path, agent);
			newAnimation.getChildren().add(pt);
			createLineAnimations(oldX, oldY, x, y);
			drawPen = true;
		}
		
		if (direction != 0) {
			RotateTransition rt = new RotateTransition(Duration.millis(50), agent);
			rt.setByAngle((int) direction);
			newAnimation.getChildren().add(rt);
			drawPen = false;
		}
		newAnimation.setOnFinished(event -> playNextAnimation());
		myAnimationQueue.add(newAnimation);
		runAnimation();
	}
	
	private void createLineAnimations(double oldX, double oldY, double x, double y) {
		double totalDistance = Math.sqrt( Math.pow((x - oldX), 2) + Math.pow((y - oldY), 2));
		
		double xOffset = (x - oldX) / totalDistance;
		double yOffset = (y - oldY) / totalDistance;
		
		Queue<Animation> penLines = new LinkedList<Animation>();
		
		for (int i = 0; i < totalDistance; i++) {
			FadeTransition lineAnimation = new FadeTransition(Duration.millis(1000),
					new Line(oldX, oldY, oldX + i * xOffset, oldY + i * yOffset));
			lineAnimation.setFromValue(1.0);
		    lineAnimation.setToValue(1.0);
			penLines.add(lineAnimation);
		}
		myLineAnimationQueue.add(penLines);
	}
	
	protected void playNextAnimation() {
		if (!myAnimationQueue.isEmpty()) {
			myAnimation = myAnimationQueue.poll();
			if (!myLineAnimationQueue.isEmpty()) {
				myLineAnimation = myLineAnimationQueue.poll();
			}
			play();
		}
	}
	
	protected void play() {
		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().add(myAnimation);
		if (drawPen && !myLineAnimation.isEmpty()) {
			for (Animation f: myLineAnimation) {
				parallelTransition.getChildren().add(f);
			}
		}
		parallelTransition.play();
	}
	
	protected void pause() {
		myAnimation.pause();
	}
}
