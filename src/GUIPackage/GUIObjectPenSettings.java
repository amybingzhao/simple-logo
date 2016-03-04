package GUIPackage;

import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class GUIObjectPenSettings implements IGUIObject{
	
	private static final int VBOX_SPACING = 10;
	private ResourceBundle myResources;
	private GUICanvas myCanvas;
	
	public GUIObjectPenSettings(ResourceBundle r, GUICanvas c) {
		myResources = r;
		myCanvas = c;
	}
	@Override
	public Node createNode() {
		VBox myBox = new VBox(VBOX_SPACING);
		
		
		
		return myBox;
	}

	@Override
	public void updateNode() {
		// TODO Auto-generated method stub
		
	}

}
