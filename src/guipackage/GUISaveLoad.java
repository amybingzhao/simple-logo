package guipackage;

import java.io.File;
import java.util.ResourceBundle;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

public class GUISaveLoad implements IGUIObject {
	private ResourceBundle myResources;
	private Controller myController;
	private GUICanvas myCanvas;
	
	private static final int PADDING = 10;

	public GUISaveLoad(ResourceBundle r, Controller c, GUICanvas canvas) {
		myResources = r;
		myController = c;
		myCanvas = canvas;
	}
	
	@Override
	public Node createNode() {
		VBox myBox = new VBox(PADDING);
		myBox.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		
		Button saveButton = new Button(myResources.getString("Save"));
		saveButton.setOnAction(e -> myController.save(promptForFileName(true)));
		
		Button loadButton = new Button(myResources.getString("Load"));
		loadButton.setOnAction(e -> loadCanvasProperties());
		
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
    
    private void loadCanvasProperties() {
    	myController.loadXML(promptForFileName(false));
    	myCanvas.setBackgroundColor(myCanvas.stringToColor(myController.getXMLParser().getBackgroundColor()),
    			myController.getXMLParser().getBackgroundColor());
    	myCanvas.setPenColor(myCanvas.stringToColor(myController.getXMLParser().getPenColor()),
    			myController.getXMLParser().getPenColor());
    	myCanvas.setTurtleShape(myCanvas.stringToImage(myController.getXMLParser().getTurtleImage()),
    			myController.getXMLParser().getTurtleImage());
    }

	@Override
	public void updateNode() {
		// TODO Auto-generated method stub

	}

}
