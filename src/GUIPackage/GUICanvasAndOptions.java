package GUIPackage;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import Controller.Controller;
import java.util.ResourceBundle;

public class GUICanvasAndOptions {
	
	private static final int TURTLE_SIZE = 10;
	private Canvas myCanvas;
	private GraphicsContext myGC;
	private TurtleObserver myTurtle;

	public GUICanvasAndOptions(Controller c, ResourceBundle resources, String x, String y) {
		myGC = myCanvas.getGraphicsContext2D();
	}

	public Node createNode() {
		myCanvas = new Canvas(250, 250);
		return myCanvas;
	}

	public void setBackground(Color c) {
		myGC.setFill(c);
	}
	
	public void setTurtleImage(Image i) {
		myGC.drawImage(i, myTurtle.getX(), myTurtle.getY(), TURTLE_SIZE, TURTLE_SIZE);
	}
	
	public Canvas getCanvas() {
		return myCanvas;
	}
}
