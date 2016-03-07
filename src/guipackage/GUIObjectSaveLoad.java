package guipackage;

import java.util.ResourceBundle;

import controller.Controller;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class GUIObjectSaveLoad implements IGUIObject {
	private ResourceBundle myResources;
	private Controller myController;
	
	private static final int VBOX_PADDING = 10;
	
	public GUIObjectSaveLoad(ResourceBundle r, Controller c) {
		myResources = r;
		myController = c;
	}
	
	@Override
	public Node createNode() {
		VBox myBox = new VBox(VBOX_PADDING);
		
		Button saveButton = new Button(myResources.getString("Save"));
//		saveButton.setOnAction(e -> );
		
		Button loadButton = new Button(myResources.getString("Load"));
//		loadButton.setOnAction(e -> );
		
		myBox.getChildren().addAll(saveButton, loadButton);
		
		return myBox;
	}

	@Override
	public void updateNode() {
		// TODO Auto-generated method stub

	}

}
