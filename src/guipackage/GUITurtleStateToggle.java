package guipackage;

import java.util.ResourceBundle;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class GUITurtleStateToggle implements IGUIObject {
	private static final int PADDING = 10;
	private Label label;
	private ToggleGroup toggleGroup;
	private RadioButton show;
	private RadioButton hide;
	private ResourceBundle myResources;
	private GUICanvas canvas;
	
	public GUITurtleStateToggle(ResourceBundle myResources, GUICanvas canvas) {
		this.myResources = myResources;
		this.canvas = canvas;
	}

	@Override
	public Node createNode() {
		VBox vboxToReturn = new VBox(PADDING);
		vboxToReturn.setPadding(new Insets(PADDING,PADDING,PADDING,PADDING));
		initToggleGroup();
		vboxToReturn.getChildren().addAll(label,show,hide);
		return vboxToReturn;
	}

	@Override
	public void updateNode() {
	}
	
	public void initToggleGroup(){
		label = new Label(myResources.getString("ShowHideLabel"));
		toggleGroup = new ToggleGroup();
		
		show = new RadioButton(myResources.getString("Show"));
		show.setToggleGroup(toggleGroup);
		show.setSelected(true);
		show.setUserData(myResources.getString("ShowTrue"));
		
		hide = new RadioButton(myResources.getString("Hide"));
		hide.setToggleGroup(toggleGroup);
		hide.setUserData(myResources.getString("HideFalse"));
		
		toggleGroup.selectedToggleProperty().addListener(
				e -> {
					canvas.getTurtleImageView().setVisibility(toggleGroup.getSelectedToggle().getUserData().toString());
				});
	}

}
