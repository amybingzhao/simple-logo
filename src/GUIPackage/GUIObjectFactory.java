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
	private ResourceBundle myResources;
	private GUICanvasAndOptions canvas;
	private Controller myController;
	
	public GUIObjectFactory(ResourceBundle myResources, Controller myController, GUICanvasAndOptions canvas){
		this.myResources = myResources;
		this.canvas = canvas; 
		this.myController = myController;
	}
	
	public GUIObject createNewGUIObject(String nodeTypeKey){
		String nodeType = myResources.getString(nodeTypeKey);
		switch(nodeType){
			case("CommandLineVBox"):{
				
			}
			case("ExceptionHandlerLabeled"):{
				return new GUIObjectLabeled(Integer.parseInt(myResources.getString("ExceptionHandlerX")),
						Integer.parseInt(myResources.getString("ExceptionHandlerX")));
			}
			case("ImageVBox"):{
				return new GUIObjectVBox(myResources, canvas, nodeType, 
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
				return new GUIObjectComboBoxCommandHist(myResources, myController, 
						Integer.parseInt(myResources.getString("PreviousCommandsX")), 
						Integer.parseInt(myResources.getString("PreviousCommandsY")));
			}
			case("HelpTabPane"):{
				
			}
		}
		return null;
	}
}
