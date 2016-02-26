package GUIPackage;
import java.util.ResourceBundle;

import Controller.Controller;
import javafx.scene.Node;
/**
 * Instantiate GUIObjects based on String passed in.
 * @author AnnieTang
 *
 */
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
				new GUIObjectLabeled(Integer.parseInt(myResources.getString("ExceptionHandlerX")),
						Integer.parseInt(myResources.getString("ExceptionHandlerX")));
			}
			case("ImageVBox"):{
				new GUIObjectVBox(myResources, canvas, nodeType, 
						Integer.parseInt(myResources.getString("ImageX")), 
						Integer.parseInt(myResources.getString("ImageY")));
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
