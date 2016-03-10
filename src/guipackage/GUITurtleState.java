package guipackage;

import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import model.Turtle;
/**
 * Shows current state of Turtle that is being hovered over. 
 * @author AnnieTang
 *
 */
public class GUITurtleState implements IGUIObject {
	private GUILabeled locationLabel;
	private GUILabeled headingLabel;
	private GUILabeled penLabel;
	private Node locationNode;
	private Node headingNode;
	private Node penNode;
	private ResourceBundle myResources;
	
	
	public GUITurtleState(ResourceBundle myResources, GUILabeled locationLabel, GUILabeled headingLabel, 
			GUILabeled penLabel) {
		this.myResources = myResources; 
		this.locationLabel = locationLabel;
		this.headingLabel = headingLabel;
		this.penLabel = penLabel;
	}

	@Override
	public Node createNode() {
		VBox vbox = new VBox();
		GUILabeled instructionLabel = new GUILabeled(myResources, myResources.getString("TurtleStateInstructions"));
		locationLabel.setOutputText(myResources.getString("StartingTurtleLocation"));
		headingLabel.setOutputText(myResources.getString("StartingTurtleHeading"));
		penLabel.setOutputText(myResources.getString("StartingPenDownStatus"));
		setFontStyle();
		vbox.getChildren().addAll(instructionLabel.createNode(), 
		locationNode, headingNode, penNode);
		return vbox;
	}
	
	private void setFontStyle(){
		locationNode = locationLabel.createNode();
		headingNode = headingLabel.createNode();
		penNode = penLabel.createNode();
		locationNode.setStyle(myResources.getString("FontStyle"));
		headingNode.setStyle(myResources.getString("FontStyle"));
		penNode.setStyle(myResources.getString("FontStyle"));
	}

	@Override
	public void updateNode() {
	}
	
	public void showTurtleState(Turtle turtle){
		locationLabel.setOutputText(Math.round(turtle.getCurX()) + "," + Math.round(turtle.getCurY()));
		headingLabel.setOutputText(""+Math.round(turtle.getDirection()));
		penLabel.setOutputText(Boolean.toString(!turtle.isPenUp()));
	}

}
