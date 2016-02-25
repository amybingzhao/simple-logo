package GUIPackage;
import java.util.ResourceBundle;

import javafx.scene.Node;

public class GUIObjectFactory {
	private static final String GUI_RESOURCE = "GUI";
	ResourceBundle myResources;
	
	
	public GUIObjectFactory(){
		this.myResources = ResourceBundle.getBundle(GUI_RESOURCE);
	}
	
	public GUIObject createNewGUIObject(String nodeTypeKey){
		String nodeType = myResources.getString(nodeTypeKey);
		switch(nodeType){
			case("CommandLineVBox"):{
				
			}
			case("ExceptionHandlerLabeled"):{
				
			}
			case("Canvas"):{
				
			}
			case("ImageVBox"):{
				
			}
			case("BackgroundVBox"):{
				
			}
			case("PenVBox"):{
				
			}
			case("LanguageComboBox"):{
				
			}
			case("VariablesTableView"):{
				
			}
			case("UserCommandsComboBox"):{
				
			}
			case("PreviousCommandsComboBox"):{
				
			}
			case("HelpTabPane"):{
				
			}
		}
		return null;
	}
}
