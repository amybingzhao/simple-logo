package GUIPackage;

import java.util.List;

import Controller.Controller;

/**
 * Create a ComboBox to hold command history. 
 * @author AnnieTang
 *
 */

public class GUIObjectComboBoxCommandHist extends GUIObjectComboBox {
	
	public GUIObjectComboBoxCommandHist(Controller contr, String nodeType, int xPos, int yPos) {
		super(contr, nodeType, xPos, yPos);
		// TODO Auto-generated constructor stub
	}

	@Override
	List<String> optionsList() {
		return contr.getCommandHistory();
	}
	
}
