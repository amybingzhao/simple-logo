package GUIPackage;

import Controller.Controller;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GUIObjectCanvas implements GUIObject {
	private static final int SIZE = 300; //
	private Controller contr;
	private Color backgroundColor; //
	private int xPos;
	private int yPos;
	private GraphicsContext gc;
	private Canvas canvas;
	
	public GUIObjectCanvas(Controller contr) {
		this.contr = contr;
	}

	@Override
	public Node createNode() {
		canvas = new Canvas(SIZE, SIZE);
		return canvas;
	}

	@Override
	public void updateNode() {
		//update background
		gc = canvas.getGraphicsContext2D();
		gc.setFill(backgroundColor);	
		
		//update turtle stuff using controller ----------------------------------
	}

	@Override
	public int getXPos() {
		return xPos;
	}

	@Override
	public int getYPos() {
		return yPos;
	}

	@Override
	public void setXPos(int val) {
		xPos = val;
	}

	@Override
	public void setYPos(int val) {
		yPos = val;
	}
	
	public void setBackgroundColor(String color){
		ColorMap cmap = new ColorMap();
		backgroundColor = (Color) cmap.get(color);
	}

}
