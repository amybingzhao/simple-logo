package GUIPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Controller.Controller;
import Model.Command;
import Model.CommandDictionary;
import javafx.scene.control.TextInputDialog;

/**
 * Create ComboBox to hold history of user defined commands. 
 * @author AnnieTang
 *
 */

public class GUIObjectComboBoxUserHist extends GUIObjectComboBox {	
	private CommandDictionary myUserDefinedCommands;
	private TextInputDialog dialog;
	
	public GUIObjectComboBoxUserHist(ResourceBundle myResources, Controller myController,
			String promptText, GUICommandLine cLine) {
		super(myResources, myController, promptText, cLine);
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
	void setButtonAction(){
		comboButton.setOnAction(event -> {
			createDialog();
			dialog.showAndWait();
			myController.processCommand(getCommandToRun());
		});
	}
	
	private void createDialog(){
		Command command = myUserDefinedCommands.getCommandFor(comboBox.getValue());
		int numArgs = command.getParams().size();
		dialog = new TextInputDialog();
		dialog.setTitle(numArgs + " " + myResources.getString("ArgumentMessage") + " " + command);
		dialog.setHeaderText(myResources.getString("ArgumentsNeeded") + command.getParams());
		dialog.setContentText(myResources.getString("RequestArguments"));
	}
	
	private String getCommandToRun(){
		String commandToRun = comboBox.getValue();
		String[] parameters = dialog.getResult().split(" ");
		for(String parameter: parameters){
			commandToRun = commandToRun + " " + parameter;
		}
		return commandToRun;
	}
}
