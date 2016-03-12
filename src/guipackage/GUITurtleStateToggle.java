package guipackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.control.ToggleGroup;

public class GUITurtleStateToggle implements IGUIObject {
	private ToggleGroup toggleGroup;
	private ResourceBundle myResources;
	private GUICanvas canvas;
	
	public GUITurtleStateToggle(ResourceBundle myResources, GUICanvas canvas) {
		this.myResources = myResources;
		this.canvas = canvas;
	}

	@Override
	public Node createNode() {
		toggleGroup = new ToggleGroup();
		toggleGroup.selectedToggleProperty().addListener(
				e -> canvas.getTurtleImageView().setVisibility(toggleGroup.getSelectedToggle().getUserData().toString()));
		GUIToggleGroup toggleGroupObj = new GUIToggleGroup(myResources.getString("ShowHideLabel"),toggleGroup,2,
				new ArrayList<>(Arrays.asList(myResources.getString("Show"),myResources.getString("Hide"))),
				0);
		return toggleGroupObj.createToggleGroupVBox();
	}

	@Override
	public void updateNode() {
	}

}
