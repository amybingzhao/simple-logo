package guipackage;

import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class GUIToggleGroup {
	private Label myToggleLabel;
	private ToggleGroup myGroup;
	private List<RadioButton> myButtons;
	private List<String> myButtonData;
	private int myTrueButtonIndex;
	
	public GUIToggleGroup(Label toggleLabel, ToggleGroup group, List<RadioButton> buttons, List<String> buttonUserData, int trueButtonIndex) {
		this.myToggleLabel = toggleLabel;
		this.myGroup = group;
		this.myButtons = buttons;
		this.myButtonData = buttonUserData;
		this.myTrueButtonIndex = trueButtonIndex;
	}

}
