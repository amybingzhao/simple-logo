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
	private Animation myAnimation;
	
	protected void makeAnimation (Node agent, double oldX, double oldY, double x, double y, double direction) {
		Path path = new Path();
		path.getElements().addAll(new MoveTo(oldX, oldY), new LineTo(x, y));
		
		PathTransition pt = new PathTransition(Duration.millis(4000), path, agent);
		
		RotateTransition rt = new RotateTransition(Duration.seconds(3));
		rt.setByAngle((int) direction);
		
		myAnimation = new SequentialTransition(agent, pt, rt);
	}
	
	protected void play() {
		myAnimation.play();
	}
}
