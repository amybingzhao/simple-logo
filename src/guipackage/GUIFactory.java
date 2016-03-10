package guipackage;

import java.util.ResourceBundle;

import controller.Controller;

/**
 * Instantiate GUIObjects based on ResourceBundle key passed into createNewGUIObject(String key).
 *
 * @author AnnieTang
 */
public class GUIFactory {
	private ResourceBundle myResources;
	private GUICanvas canvas;
	private Controller myController;
	private GUICommandLine myCommandLine;

	public GUIFactory(ResourceBundle myResources, Controller myController, GUICanvas canvas, GUICommandLine cLine){
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
		case("SaveLoadButtons"):{
			return new GUISaveLoad(myResources, myController);
		}
//		case("ImageVBox"):{
//			return new GUIObjectImageVBox(myResources, myController, canvas, nodeType);
//		}
		case("PenSettings"):{
			return new GUIPenSettings(myResources, canvas);
		}
		case("ImageComboBox"):{
			return new GUIComboBoxImages(canvas, myResources, myResources.getString(nodeTypeKey+"PromptText"));
		}
		case("LanguageComboBox"):{
			return new GUIComboBoxLanguages(canvas, myResources, myController, 
					myResources.getString(nodeTypeKey+"PromptText"), myCommandLine);
		}
		case("VariablesTableView"):{
			return new GUITableView(myResources, myController.getCommandDictionary(), myController.getVariableDictionary());
		}
		case("UserCommandsComboBox"):{
			return new GUIComboBoxUserHist(canvas, myResources, myController,
					myResources.getString(nodeTypeKey + "PromptText"), myCommandLine, myController.getCommandDictionary());
		}
		case("PreviousCommandsComboBox"):{
			return new GUIComboBoxCommandHist(canvas, myResources, myController, 
					myResources.getString(nodeTypeKey+"PromptText"), myCommandLine);
		}
		case("HelpTabPane"):{
			return null;
		}
//		case("ColorPickerBackground"):{
//			return new GUIObjectColorPickerBackground(canvas,myResources.getString(nodeTypeKey+"Label"));
//		}
		case("BackgroundColorPalette"):{
			return new GUIComboBoxColorB(canvas, myResources, myResources.getString(nodeTypeKey+"PromptText"));
		}
		case("PenColorPalette"):{
			return new GUIComboBoxColorP(canvas, myResources, myResources.getString(nodeTypeKey+"PromptText"));
		}
		case("ColorPickerPen"):{
			return new GUIColorPickerPen(canvas,myResources.getString(nodeTypeKey+"Label"));
		}
		case("TurtleState"):{
			return new GUITurtleState(myResources,
					new GUILabeled(myResources, myResources.getString("TurtleLocation")),
					new GUILabeled(myResources, myResources.getString("TurtleHeading")), 
					new GUILabeled(myResources, myResources.getString("TurtlePen")),
					canvas);
		}
		}
		return null;
	}
}
