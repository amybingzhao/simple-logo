package guipackage;

import java.util.ResourceBundle;

import controller.Controller;

/**
 * Instantiate GUIObjects based on ResourceBundle key passed into createNewGUIObject(String key).
 *
 * @author AnnieTang
 */
public class GUIObjectFactory {
	private ResourceBundle myResources;
	private GUICanvas canvas;
	private Controller myController;
	private GUICommandLine myCommandLine;

	public GUIObjectFactory(ResourceBundle myResources, Controller myController, GUICanvas canvas, GUICommandLine cLine){
		this.myResources = myResources;
		this.canvas = canvas; 
		this.myController = myController;
		this.myCommandLine = cLine;
	}

	/**
	 * Creates new GUIObject based on nodeType passed in. 
	 * @param nodeTypeKey
	 * @return Specified IGUIObject
	 */
	protected IGUIObject createNewGUIObject(String nodeTypeKey){
		String nodeType = myResources.getString(nodeTypeKey);
		switch(nodeType){
		case("CommandLineVBox"):{
			return null;
		}
//		case("ImageVBox"):{
//			return new GUIObjectImageVBox(myResources, myController, canvas, nodeType);
//		}
		case("ImageComboBox"):{
			return new GUIObjectComboBoxImages(canvas, myResources, myController, 
					myResources.getString(nodeTypeKey+"PromptText"), myCommandLine);
		}
		case("LanguageComboBox"):{
			return new GUIObjectComboBoxLanguages(canvas, myResources, myController, 
					myResources.getString(nodeTypeKey+"PromptText"), myCommandLine);
		}
		case("VariablesTableView"):{
			return new GUIObjectTableView(myResources, myController.getCommandDictionary(), myController.getVariableDictionary());
		}
		case("UserCommandsComboBox"):{
			return new GUIObjectComboBoxUserHist(canvas, myResources, myController,
					myResources.getString(nodeTypeKey + "PromptText"), myCommandLine, myController.getCommandDictionary());
		}
		case("PreviousCommandsComboBox"):{
			return new GUIObjectComboBoxCommandHist(canvas, myResources, myController, 
					myResources.getString(nodeTypeKey+"PromptText"), myCommandLine);
		}
		case("HelpTabPane"):{
			return null;
		}
//		case("ColorPickerBackground"):{
//			return new GUIObjectColorPickerBackground(canvas,myResources.getString(nodeTypeKey+"Label"));
//		}
		case("BackgroundColorPalette"):{
			return new GUIObjectComboBoxColorB(canvas, myResources, myController,
					myResources.getString(nodeTypeKey+"PromptText"), myCommandLine);
		}
		case("PenColorPalette"):{
			return new GUIObjectComboBoxColorB(canvas, myResources, myController,
					myResources.getString(nodeTypeKey+"PromptText"), myCommandLine);
		}
		case("ColorPickerPen"):{
			return new GUIObjectColorPickerPen(canvas,myResources.getString(nodeTypeKey+"Label"));
		}
		case("TurtleState"):{
			return new GUIObjectTurtleState(myResources,
					new GUIObjectLabeled(myResources, myResources.getString("TurtleLocation")),
					new GUIObjectLabeled(myResources, myResources.getString("TurtleHeading")), 
					new GUIObjectLabeled(myResources, myResources.getString("TurtlePen")),
					canvas);
		}
		}
		return null;
	}
}
