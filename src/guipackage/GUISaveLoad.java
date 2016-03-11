package guipackage;

import java.io.File;
import java.util.ResourceBundle;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
    	myCanvas.setBackgroundColor(stringToColor(myController.getXMLParser().getBackgroundColor()),
    			myController.getXMLParser().getBackgroundColor());
    	myCanvas.getPen().setMyPenColor(stringToColor(myController.getXMLParser().getPenColor()),
    			myController.getXMLParser().getPenColor());
    	myCanvas.setTurtleShape(stringToImage(myController.getXMLParser().getTurtleImage()),
    			myController.getXMLParser().getTurtleImage());
    }
    
    private Image stringToImage(String imageString){
    	Image image = new Image(getClass().getClassLoader().getResourceAsStream(imageString));
		return image;
    }
    
    private Color stringToColor(String colorString) {
		String[] rgb = colorString.split(" ");
		Color col = Color.rgb((int) Double.parseDouble(rgb[0]),
				(int) Double.parseDouble(rgb[1]), (int) Double.parseDouble(rgb[2]));
		return col;
	}

	@Override
	public void updateNode() {
		// TODO Auto-generated method stub

	}

}
