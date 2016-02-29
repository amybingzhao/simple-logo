package GUIPackage;

import java.util.List;
import java.util.ResourceBundle;

import Controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

/**
 * Abstract class to implement different types of ComboBoxes. 
 * "In Java, an abstract class can implement an interface, and not provide implementations of 
 * all of the interface's methods. It is the responsibility of the first concrete class that 
 * has that abstract class as an ancestor to implement all of the methods in the interface."
 * @author AnnieTang
 */

abstract class GUIObjectComboBox implements GUIObject {
	private static final int VISIBLE_ROW_COUNT = 5;
	private String promptText;
	protected ResourceBundle myResources;
	protected Controller myController;
	protected ObservableList<String> options;
	protected ComboBox<String> comboBox;
	
	public GUIObjectComboBox(ResourceBundle myResources, Controller myController, String promptText) {
		this.myResources = myResources;
		this.myController = myController;
		this.promptText = promptText;
	}
	
	@Override
	public Node createNode() {
		options = FXCollections.observableArrayList(
			        optionsList()
			    );
		comboBox = new ComboBox<String>(options);
		comboBox.setVisibleRowCount(VISIBLE_ROW_COUNT);
		comboBox.setPromptText(promptText);
		setComboBoxAction();
		return comboBox;
	}
	
	abstract void setComboBoxAction();

	@Override
	public void updateNode() {
		ObservableList<String> newOptions = FXCollections.observableArrayList(
		        optionsList()
		    );
		comboBox.setItems(newOptions);
	}

	abstract List<String> optionsList();

}
