package GUIPackage;
import java.util.ResourceBundle;

import javafx.scene.Node;

public class GUIObjectFactory {
	private static final String GUI_RESOURCE = "XMLs/GUI";
	ResourceBundle myResources;
	private String nodeType;
	
	
	public GUIObjectFactory(String nodeType){
		this.nodeType = nodeType; 
		this.myResources = ResourceBundle.getBundle(GUI_RESOURCE);
	}
	
	public Node createNewGUIObject(){
		switch(nodeType){
			case(""):{
				return null;
			}
			case(" "):{
				return null;
			}
		}
		return null;
	}
	
}
