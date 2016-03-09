package guipackage;

import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class GUIObjectTurtleState implements IGUIObject {
	private GUIObjectLabeled locationLabel;
	private GUIObjectLabeled headingLabel;
	private GUIObjectLabeled penLabel;
	private GUICanvas canvas;
	private ResourceBundle myResources;
	
	
	public GUIObjectTurtleState(ResourceBundle myResources, GUIObjectLabeled locationLabel, GUIObjectLabeled headingLabel, 
			GUIObjectLabeled penLabel, GUICanvas canvas) {
		this.myResources = myResources; 
		this.locationLabel = locationLabel;
		this.headingLabel = headingLabel;
		this.penLabel = penLabel;
		this.canvas = canvas;
	}

	@Override
	public Node createNode() {
		VBox vbox = new VBox();
		GUIObjectLabeled instructionLabel = new GUIObjectLabeled(myResources, myResources.getString("TurtleStateInstructions"));
		locationLabel.setOutputText(myResources.getString("StartingTurtleLocation"));
		headingLabel.setOutputText(myResources.getString("StartingTurtleHeading"));
		penLabel.setOutputText(myResources.getString("StartingPenDownStatus"));
		vbox.getChildren().addAll(instructionLabel.createNode(), locationLabel.createNode(), 
				headingLabel.createNode(), penLabel.createNode());
		return vbox;
	}

	@Override
	public void updateNode() {
//		locationLabel.setOutputText(canvas.getCoordinateString());
//		headingLabel.setOutputText(canvas.getHeadingString());
//		penLabel.setOutputText(Boolean.toString(canvas.getPenDownStatus()));
	}

}
