package GUIPackage;

import java.util.ArrayList;
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
//		return contr.getCommandHistory();
		List<String> test = new ArrayList<String>();
		test.add("testing");
		return test;
	}
	
}
