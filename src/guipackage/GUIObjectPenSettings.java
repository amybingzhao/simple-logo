package guipackage;

import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class GUIObjectPenSettings implements IGUIObject{
	
	private static final int VBOX_SPACING = 5;
	private ResourceBundle myResources;
	private GUICanvas myCanvas;
	
	public GUIObjectPenSettings(ResourceBundle r, GUICanvas c) {
		myResources = r;
		myCanvas = c;
	}
	@Override
	public Node createNode() {
		VBox myBox = new VBox(VBOX_SPACING);
		
		Label upDownLabel = new Label("Select Pen Up or Down");
		
		ToggleGroup penUpDownGroup = new ToggleGroup();
		
		RadioButton penUp = new RadioButton(myResources.getString("PenUp"));
		penUp.setToggleGroup(penUpDownGroup);
		penUp.setSelected(true);
		penUp.setUserData(myResources.getString("PenUp"));
		
		RadioButton penDown = new RadioButton(myResources.getString("PenDown"));
		penDown.setToggleGroup(penUpDownGroup);
		penDown.setUserData(myResources.getString("PenDown"));
		
		penUpDownGroup.selectedToggleProperty().addListener(
				e -> myCanvas.setPen(penUpDownGroup.getSelectedToggle().getUserData().toString()));
		
		Label penTypeLabel = new Label("Select Line Type");
		
		ToggleGroup penTypeGroup = new ToggleGroup();
		
		RadioButton penSolid = new RadioButton("Solid Pen");
		penSolid.setToggleGroup(penTypeGroup);
		penSolid.setSelected(true);
		
		RadioButton penDashed = new RadioButton("Dashed Pen");
		penDashed.setToggleGroup(penTypeGroup);
		
		RadioButton penDotted = new RadioButton("Dotted Pen");
		penDotted.setToggleGroup(penTypeGroup);
		
		Label penLabel = new Label("Enter Pen Thickness");
		
		TextField penThickness = new TextField();
		Button setThickness = new Button("Set Thickness");
		setThickness.setOnAction(event -> myCanvas.setPenSize(Double.valueOf(penThickness.getText())));
		

		myBox.getChildren().addAll(upDownLabel, penUp, penDown, penTypeLabel, penSolid, 
				penDashed, penDotted, penLabel, penThickness, setThickness);
		
		return myBox;
	}

	@Override
	public void updateNode() {
		// TODO Auto-generated method stub
		
	}

}
