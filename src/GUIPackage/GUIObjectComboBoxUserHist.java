package GUIPackage;

import java.util.List;
import java.util.ResourceBundle;

import Controller.Controller;

/**
 * Create ComboBox to hold history of user defined commands. 
 * @author AnnieTang
 *
 */

public class GUIObjectComboBoxUserHist extends GUIObjectComboBox {	
	public GUIObjectComboBoxUserHist(ResourceBundle myResources, Controller contr, int xPos, int yPos) {
		super(myResources, contr, xPos, yPos);
	}

	@Override
	List<String> optionsList() {
		return contr.getCommandHistory();
		//should be getUserHistory, but is not implemented yet
	}


}
