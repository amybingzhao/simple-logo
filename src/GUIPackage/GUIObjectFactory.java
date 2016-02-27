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
				return null;
			}
			case("ExceptionHandlerLabeled"):{
				return new GUIObjectLabeled(Integer.parseInt(myResources.getString("ExceptionHandlerX")),
						Integer.parseInt(myResources.getString("ExceptionHandlerY")));
			}
			case("ImageVBox"):{
				return new GUIObjectVBox(myResources, canvas, nodeType, 
						Integer.parseInt(myResources.getString("ImageX")), 
						Integer.parseInt(myResources.getString("ImageY")));
			}
			case("LanguageComboBox"):{
				return new GUIObjectComboBoxLanguages(myResources, myController, 
						myResources.getString(nodeTypeKey+"PromptText"),
						Integer.parseInt(myResources.getString("LanguageSelectorX")), 
						Integer.parseInt(myResources.getString("LanguageSelectorY")));
			}
			case("VariablesTableView"):{
				return null;
			}
			case("UserCommandsComboBox"):{
				return new GUIObjectComboBoxUserHist(myResources, myController,
						myResources.getString(nodeTypeKey+"PromptText"),
						Integer.parseInt(myResources.getString("UserCommandsX")), 
						Integer.parseInt(myResources.getString("UserCommandsY")));
			}
			case("PreviousCommandsComboBox"):{
				return new GUIObjectComboBoxCommandHist(myResources, myController, 
						myResources.getString(nodeTypeKey+"PromptText"),
						Integer.parseInt(myResources.getString("PreviousCommandsX")), 
						Integer.parseInt(myResources.getString("PreviousCommandsY")));
			}
			case("HelpTabPane"):{
				return null;
			}
			case("ColorPickerBackground"):{
				return new GUIObjectColorPickerBackground(canvas,myResources.getString(nodeTypeKey+"Label"), 0,0);
			}
			case("ColorPickerPen"):{
				return new GUIObjectColorPickerPen(canvas,myResources.getString(nodeTypeKey+"Label"), 0,0);
			}
		}
		return null;
	}
}
