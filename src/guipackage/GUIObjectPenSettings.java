package guipackage;

import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class GUIObjectPenSettings implements IGUIObject{
	
	private static final int VBOX_SPACING = 10;
	private ResourceBundle myResources;
	private GUICanvas myCanvas;
	
	public GUIObjectPenSettings(ResourceBundle r, GUICanvas c) {
		myResources = r;
		myCanvas = c;
	}
	@Override
	public Node createNode() {
		VBox myBox = new VBox(VBOX_SPACING);
		
		ToggleGroup penUpDownGroup = new ToggleGroup();
		
		RadioButton penUp = new RadioButton("Pen Up");
		penUp.setToggleGroup(penUpDownGroup);
		penUp.setSelected(true);
		
		RadioButton penDown = new RadioButton("Pen Down");
		penDown.setToggleGroup(penUpDownGroup);
		
		
		ToggleGroup penTypeGroup = new ToggleGroup();
		
		RadioButton penSolid = new RadioButton("Solid Pen");
		penSolid.setToggleGroup(penTypeGroup);
		penSolid.setSelected(true);
		
		RadioButton penDashed = new RadioButton("Dashed Pen");
		penDashed.setToggleGroup(penTypeGroup);
		
		RadioButton penDotted = new RadioButton("Dotted Pen");
		penDotted.setToggleGroup(penTypeGroup);
		
		
		TextField penThickness = new TextField("Enter Desired Pen Thickness");
		Button setThickness = new Button("Set Thickness");
//		setThickness.setOnAction(event -> )
		
		
		
		return myBox;
	}

	@Override
	public void updateNode() {
		// TODO Auto-generated method stub
		
	}

}
