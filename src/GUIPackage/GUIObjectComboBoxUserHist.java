package GUIPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Controller.Controller;

/**
 * Create ComboBox to hold history of user defined commands. 
 * @author AnnieTang
 *
 */

public class GUIObjectComboBoxUserHist extends GUIObjectComboBox {	
	public GUIObjectComboBoxUserHist(ResourceBundle myResources, Controller myController, String promptText, int xPos, int yPos) {
		super(myResources, myController, promptText, xPos, yPos);
	}

	@Override
	List<String> optionsList() {
//		return contr.getCommandHistory();
		//should be getUserHistory, but is not implemented yet
		List<String> test = new ArrayList<String>();
		test.add("testing");
		return test;
	}


}
