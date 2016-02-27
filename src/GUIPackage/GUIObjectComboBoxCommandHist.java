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
	
	public GUIObjectComboBoxCommandHist(ResourceBundle myResources, Controller contr, int xPos, int yPos) {
		super(myResources, contr, xPos, yPos);
	}

	@Override
	List<String> optionsList() {
		return contr.getCommandHistory();
	}
	
}
