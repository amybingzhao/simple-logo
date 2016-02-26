package GUIPackage;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
/**
 * Area beneath command line where caught exceptions will print out descriptive messages. 
 * @author AnnieTang
 *
 */
public class GUIObjectLabeled implements GUIObject {
	private int xPos;
	private int yPos;
	private Labeled label;
	
	public GUIObjectLabeled(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	@Override
	public Node createNode() {
		label = new Label("Welcome to SLogo!");
		return label;
	}

	public void setText(String errorMessage){
		label.setText(errorMessage);
	}
	
	@Override
	public void updateNode() {
		
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

}
