package GUIPackage;
import java.util.ResourceBundle;

import Controller.Controller;
import javafx.scene.Node;

public class GUIObjectFactory {
	private static final String GUI_RESOURCE = "GUI";
	private ResourceBundle myResources;
	private GUICanvasAndOptions canvas;
	private Controller contr; 
	
	
	public GUIObjectFactory(Controller contr, GUICanvasAndOptions canvas){
		this.myResources = ResourceBundle.getBundle(GUI_RESOURCE);
		this.canvas = canvas;
		this.contr = contr;
	}
	
	public GUIObject createNewGUIObject(String nodeTypeKey){
		String nodeType = myResources.getString(nodeTypeKey);
		switch(nodeType){
			case("CommandLineVBox"):{
				
			}
			case("ExceptionHandlerLabeled"):{
				
			}
			case("ImageVBox"):{

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
