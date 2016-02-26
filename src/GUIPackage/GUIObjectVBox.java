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

public class GUIObjectVBox implements GUIObject {
	
	private static final String FILE_DIRECTORY = "Images/";
	private ResourceBundle myResources;
	private int xPos;
	private int yPos;
	private String nodeType;
//	private boolean canUpdate;
	
	private TextField userInputFileString;
	private Button initializeButton;
	private Labeled fileErrorLabel;
	private static final double PADDING = 10;
	
	public GUIObjectVBox(ResourceBundle myResources, String nodeType) {
		this.myResources = myResources;
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
		XMLControls.setSpacing(5);
		XMLControls.setPadding(new Insets(0,PADDING,PADDING,PADDING));
		
		return XMLControls;
	}

	private void setValidity(String nodeType) {
		if (isValidFileString(userInputFileString.getText())){
//			canUpdate = true;
		}
	}
	
	private boolean isValidFileString(String fileString){
		File f = new File(FILE_DIRECTORY + fileString);
		if (f.isFile()){
			return true;
		}else{
			fileErrorLabel.setText(myResources.getString("FileNotFound" + nodeType));
		}
		fileErrorLabel.setVisible(true);
		return false;
	}
	
//	public boolean isUpdateable(){
//		return canUpdate;
//	}

	@Override
	public void updateNode() {
		//possibly nothing here	
	}

	@Override
	public int getXPos() {
		return xPos;
	}

	@Override
	public int getYPos() {
		return yPos;
	}

	@Override
	public void setXPos(int val) {
		xPos = val;
	}

	@Override
	public void setYPos(int val) {
		yPos = val;
		
	}

}
