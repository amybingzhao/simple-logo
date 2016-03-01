package GUIPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import Controller.Controller;

/**
 * Create ComboBox to hold interpretable languages. 
 * @author AnnieTang
 *
 */

public class GUIObjectComboBoxLanguages extends GUIObjectComboBox {

	public GUIObjectComboBoxLanguages(ResourceBundle myResources, Controller myController,
			String promptText, GUICommandLine cLine) {
		super(myResources, myController, promptText, cLine);
	}

	@Override
	List<String> optionsList() {
		return new ArrayList<String>(Arrays.asList(myResources.getString("Languages").split(" ")));
	}

	@Override
	void setComboBoxAction() {
		comboBox.setOnAction(event -> myController.setLanguage(comboBox.getValue()));
	}

}
