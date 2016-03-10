package guipackage;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class GUICanvasAnimation {
	private SequentialTransition myAnimation;
	
	public GUICanvasAnimation() {
		myAnimation = new SequentialTransition();
	}
	
	protected void addAnimation(Node agent, double oldX, double oldY,
			double x, double y, double direction) {
		System.out.println(oldY);
		Path path = new Path();
		path.getElements().addAll(new MoveTo(oldX, oldY), new LineTo(x, y));
		if (oldX != x || oldY != y) {
			PathTransition pt = new PathTransition(Duration.millis(1000), path, agent);
			myAnimation.getChildren().add(pt);
		}
		
		if (direction != 0) {
			RotateTransition rt = new RotateTransition(Duration.seconds(3), agent);
			rt.setByAngle((int) direction);
			myAnimation.getChildren().add(rt);
		}
	}
	
	protected void play() {
		myAnimation.play();
	}
	
	protected void pause() {
		myAnimation.pause();
	}
}
