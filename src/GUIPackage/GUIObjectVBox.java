package GUIPackage;

import java.io.File;
import java.util.ResourceBundle;

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

public class GUIObjectVBox implements GUIObject {
	private ResourceBundle myResources;
	private String nodeType;
	private boolean canUpdate;
	private GUICanvas canvas;
	private TextField userInputFileString;
	private Button initializeButton;
	private Labeled fileErrorLabel;
	private static final int XMLCONTROLS_SPACING = 5;
	private static final double PADDING_TOP = 0;
	private static final double PADDING_RIGHT = 10;
	private static final double PADDING_BOTTOM = 10;
	private static final double PADDING_LEFT = 10;
	
	public GUIObjectVBox(ResourceBundle myResources, GUICanvas canvas, String nodeType) {
		this.myResources = myResources;
		this.canvas = canvas;
		this.nodeType = nodeType;
	}

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

	private void setValidity(String nodeType) {
		if (isValidFileString(userInputFileString.getText())){
			canUpdate = true;
		}
	}
	
	private boolean isValidFileString(String fileString){
		String fileDirectory = myResources.getString(nodeType + "FileDirectory");
		File f = new File(fileDirectory + fileString);
		if (f.isFile()){
			return true;
		}else{
			fileErrorLabel.setText(myResources.getString("FileNotFound" + nodeType));
		}
		fileErrorLabel.setVisible(true);
		return false;
	}
	
	public boolean isUpdateable(){
		return canUpdate;
	}

	@Override
	public void updateNode() {
		if(canUpdate){
			canvas.setImage();
		}
	}
}
