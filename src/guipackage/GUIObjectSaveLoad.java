package guipackage;

import java.io.File;
import java.util.ResourceBundle;

import controller.Controller;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

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
		saveButton.setOnAction(e -> myController.save(promptForFileName(true)));
		
		Button loadButton = new Button(myResources.getString("Load"));
		loadButton.setOnAction(e -> myController.loadXML(promptForFileName(false)));
		
		myBox.getChildren().addAll(saveButton, loadButton);
		
		return myBox;
	}

    /**
     * Creates a file picker to get a file name
     * @return returns the file
     */
    private File promptForFileName(boolean isSaving){
        FileChooser myFileChooser = new FileChooser();
        FileChooser.ExtensionFilter myFilter = new FileChooser.ExtensionFilter("XML Files (.xml)", "*.xml");
        myFileChooser.getExtensionFilters().add(myFilter);
        File fileName;
        if (isSaving){
            fileName = myFileChooser.showSaveDialog(myController.getStage());
        }
        else{
            fileName = myFileChooser.showOpenDialog(myController.getStage());
        }
        return fileName;
    }

	@Override
	public void updateNode() {
		// TODO Auto-generated method stub

	}

}
