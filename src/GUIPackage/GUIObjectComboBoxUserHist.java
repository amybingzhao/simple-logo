package GUIPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Controller.Controller;
import Model.CommandDictionary;

/**
 * Create ComboBox to hold history of user defined commands. 
 * @author AnnieTang
 *
 */

public class GUIObjectComboBoxUserHist extends GUIObjectComboBox {	
	private CommandDictionary myUserDefinedCommands;
	
	public GUIObjectComboBoxUserHist(ResourceBundle myResources, Controller myController, String promptText) {
		super(myResources, myController, promptText);
	}

	@Override
	List<String> optionsList() {
		myUserDefinedCommands = CommandDictionary.getInstance();
		List<String> userDefinedCommands = new ArrayList<String>();
		for(String s: myUserDefinedCommands.getCommandKeySet()){
			userDefinedCommands.add(s);
		}
		return userDefinedCommands;
	}

	@Override
	void setComboBoxAction() {
		comboBox.setOnAction(event -> myController.processCommand(comboBox.getValue()));
	}


}
