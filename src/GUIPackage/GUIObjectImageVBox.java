package GUIPackage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Load different types of file input (e.g. image file to use for Turtle). File directory is based on
 * what is specified for the nodeType in the ResourceBundle.  
 * @author AnnieTang
 *
 */

public class GUIObjectImageVBox implements IGUIObject {
	private static final String IMAGE_FILE_TYPES = "png jpg tif gif";
	private ResourceBundle myResources;
	private String nodeType;
	private boolean canUpdate;
	private GUICanvas canvas;
	private Controller myController;
	private TextField userInputFileString;
	private Button initializeButton;
	private Labeled fileErrorLabel;
	private File imageFile;
	private static final int XMLCONTROLS_SPACING = 5;
	private static final double PADDING_TOP = 0;
	private static final double PADDING_RIGHT = 10;
	private static final double PADDING_BOTTOM = 10;
	private static final double PADDING_LEFT = 10;
	
	public GUIObjectImageVBox(ResourceBundle myResources, Controller myController, GUICanvas canvas, String nodeType) {
		this.myResources = myResources;
		this.myController = myController;
		this.canvas = canvas;
		this.nodeType = nodeType;
	}
	
	/**
	 * Create Node for VBox
	 */
	@Override
	public Node createNode() {
		fileErrorLabel = new Label();
		fileErrorLabel.setVisible(false);
		
		userInputFileString = new TextField(myResources.getString("LoadFileType" + nodeType));
		initializeButton = new Button(myResources.getString("InitializeButtonText" + nodeType));
		initializeButton.setOnAction(evt -> setValidity(nodeType));
		
		VBox XMLControls = new VBox();
		XMLControls.getChildren().addAll(userInputFileString, initializeButton,fileErrorLabel);
		XMLControls.setSpacing(XMLCONTROLS_SPACING);
		XMLControls.setPadding(new Insets(PADDING_TOP, PADDING_RIGHT, PADDING_BOTTOM, PADDING_LEFT));
		
		return XMLControls;
	}
	
	/**
	 * Sets the canUpdate boolean to true.
	 * @param nodeType
	 */
	private void setValidity(String nodeType) {
		if (isValidFileString(userInputFileString.getText())){
			canUpdate = true;
			updateNode();
		}
	}
	
	/**
	 * Checks if fileString is an actual file
	 * @param fileString
	 * @return
	 */
	private boolean isValidFileString(String fileString){
		String fileDirectory = myResources.getString(nodeType + "FileDirectory");
		File f = new File(fileDirectory + fileString);
		if (f.isFile()){
			imageFile = f;
			return true;
		}else{
			if(!isValidImageFormat(fileString)){
				myController.displayAlert("InvalidImageFormat");
		}else{
			myController.displayAlert("ImageNotFound");
		}
		fileErrorLabel.setVisible(true);
		return false;
		}
	}
	
	/**
	 * Checks if fileString is an Image format
	 * @param fileString
	 * @return
	 */
	private boolean isValidImageFormat(String fileString){
		ArrayList<String> validFormats = new ArrayList<String>(Arrays.asList(IMAGE_FILE_TYPES.split(" ")));
		String attemptedFormat = fileString.substring(fileString.length()-3, fileString.length());
		return validFormats.contains(attemptedFormat.toLowerCase());
	}
	
	/**
	 * Returns canUpdate when called.
	 * @return true if  canUpdate is true, false if canUpdate is false
	 */
	protected boolean isUpdateable(){
		return canUpdate;
	}
	
	/**
	 * Updates VBox Node when called.
	 */
	@Override
	public void updateNode() {
		if(canUpdate){
			canvas.setImage(imageFile);
		}
	}
}
