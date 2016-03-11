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
			return new GUISaveLoad(myResources, myController, canvas);
		}
		case("ImageComboBox"):{
			return new GUIComboBoxImages(canvas, myResources, myResources.getString(nodeTypeKey+"PromptText"));
		}
		case("LanguageComboBox"):{
			return new GUIComboBoxLanguages(canvas, myResources, myController, 
					myResources.getString(nodeTypeKey+"PromptText"), myCommandLine);
		}
		case("VariablesTableView"):{
			return new GUITableView(myResources, myController.getVariableDictionary());
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
//		case("TurtleState"):{
//			return new GUITurtleState(myResources,
//					new GUILabeled(myResources, myResources.getString("TurtleLocation")),
//					new GUILabeled(myResources, myResources.getString("TurtleHeading")), 
//					new GUILabeled(myResources, myResources.getString("TurtlePen")));
//		}
		case("CanvasRight"):{
			return new GUICanvasRight(myResources, new GUIComboBoxColorB(canvas, myResources, myResources.getString("BackgroundColorPalettePromptText"),
					myResources.getString("DefaultBackgroundColors")), new GUIComboBoxColorP(canvas, myResources, 
							myResources.getString("PenColorPalettePromptText"), myResources.getString("DefaultPenColors")),
					new GUIComboBoxImages(canvas, myResources, myResources.getString("ImageComboBoxPromptText")),
					new GUIPenSettings(myResources, canvas),
					new GUITurtleState(myResources, new GUILabeled(myResources, myResources.getString("TurtleLocation")),
													new GUILabeled(myResources, myResources.getString("TurtleHeading")), 
													new GUILabeled(myResources, myResources.getString("TurtlePen"))));
		}
		}
		return null;
	}
}
