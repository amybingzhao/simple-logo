package GUIPackage;

import java.util.List;
import java.util.ResourceBundle;

import Controller.Controller;

/**
 * Create a ComboBox to hold command history. 
 * @author AnnieTang
 *
 */

public class GUIObjectComboBoxCommandHist extends GUIObjectComboBox {
	
	public GUIObjectComboBoxCommandHist(ResourceBundle myResources, Controller myController,
			String promptText, GUICommandLine cLine) {
		super(myResources, myController, promptText, cLine);
	}

	@Override
	protected List<String> optionsList() {
		return myController.getCommandHistory();
	}

	@Override
	protected void setButtonAction(){
		comboButton.setOnAction(event -> {
			myCommandLine.runCommand(comboBox.getValue());
		});
	}
	
}
