package GUIPackage;

import java.util.List;

import Controller.Controller;

/**
 * Create ComboBox to hold history of user defined commands. 
 * @author AnnieTang
 *
 */

public class GUIObjectComboBoxUserHist extends GUIObjectComboBox {	
	public GUIObjectComboBoxUserHist(Controller contr, String nodeType, int xPos, int yPos) {
		super(contr, nodeType, xPos, yPos);
		// TODO Auto-generated constructor stub
	}

	@Override
	List<String> optionsList() {
		return contr.getCommandHistory();
		//should be getUserHistory, but is not implemented yet
	}


}
