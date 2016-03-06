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
	
	public GUIObjectComboBoxCommandHist(GUICanvas canvas, ResourceBundle myResources, Controller myController,
			String promptText, GUICommandLine myCommandLine) {
		super(canvas, myResources, myController, promptText, myCommandLine);
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

	@Override
	protected void setCellFactory() {		
	}
	
}
