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
	
	public GUIObjectComboBoxCommandHist(ResourceBundle myResources, Controller myController, String promptText) {
		super(myResources, myController, promptText);
	}

	@Override
	List<String> optionsList() {
		return myController.getCommandHistory();
	}

	@Override
	void setComboBoxAction(){
		comboBox.setOnAction(event -> myController.processCommand(comboBox.getValue()));
	}
	
}
