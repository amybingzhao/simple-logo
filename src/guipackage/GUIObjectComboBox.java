package guipackage;

import java.util.List;
import java.util.ResourceBundle;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

/**
 * Abstract class to implement different types of ComboBoxes. 
 * "In Java, an abstract class can implement an interface, and not provide implementations of 
 * all of the interface's methods. It is the responsibility of the first concrete class that 
 * has that abstract class as an ancestor to implement all of the methods in the interface."
 * @author AnnieTang
 */

public abstract class GUIObjectComboBox implements IGUIObject {
	private static final int COMBOBOX_WIDTH = 190;
	private static final int VISIBLE_ROW_COUNT = 5;
	private static final int PADDING = 10;
	private static final int HBOX_SPACING = 5;
	protected String promptText;
	protected ResourceBundle myResources;
	protected Controller myController;
	protected ObservableList<String> options;
	protected ComboBox<String> comboBox;
	protected GUICommandLine myCommandLine;
	protected Button comboButton;
	protected GUICanvas canvas;
	
	public GUIObjectComboBox(GUICanvas canvas, ResourceBundle myResources, Controller myController, String promptText, GUICommandLine myCommandLine) {
		this.canvas = canvas;
		this.myResources = myResources;
		this.myController = myController;
		this.promptText = promptText;
		this.myCommandLine = myCommandLine;
	}
	
	public GUIObjectComboBox(GUICanvas canvas, ResourceBundle myResources, String promptText){
		this.canvas = canvas;
		this.myResources = myResources;
		this.promptText = promptText;
	}
	
	/**
	 * Creates ComboBox Node.
	 */
	@Override
	public Node createNode(){
		HBox hbox = new HBox(HBOX_SPACING);
		options = FXCollections.observableArrayList(
			        optionsList()
			    );
		comboBox = new ComboBox<String>(options);
		comboBox.setVisibleRowCount(VISIBLE_ROW_COUNT);
		comboBox.setPrefWidth(COMBOBOX_WIDTH);
		comboBox.setPromptText(promptText);
		setCellFactory();
		comboButton = new Button("Go");
		setButtonAction();
		hbox.getChildren().addAll(comboBox, comboButton);
		hbox.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		return hbox;
	}
	
	/**
	 * Sets action when button is pressed.
	 */
	protected abstract void setButtonAction();
	
	/**
	 * Sets cell factory of ComboBox.
	 */
	protected abstract void setCellFactory();
	/**
	 * Updates Node whenever new information or data is available.
	 */
	@Override
	public void updateNode() {
		ObservableList<String> newOptions = FXCollections.observableArrayList(
		        optionsList()
		    );
		comboBox.setItems(newOptions);
	}
	
	/**
	 * List that contains Data for each ComboBox.
	 * @return
	 */
	protected abstract List<String> optionsList();
	
	public void changePalette(String RGB, int index) {
		List<String> currentPalette = comboBox.getItems();
		currentPalette.set(index, RGB);
		updateNode();
	}
	
	public List<String> getOptionsList(){
		return optionsList();
	}

}
