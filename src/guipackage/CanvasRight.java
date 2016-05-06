/**
 * Modified for VOOGASalad addition
 */

package guipackage;

import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import model.Turtle;
/**
 * Returns vbox of GUI objects to be placed to the right of the canvas.
 * @author AnnieTang
 *
 */
public class CanvasRight {
	GUIComboBoxColor myBackgroundPalette;
	GUIComboBoxColor myPenPalette;
	GUIComboBoxImages myImagePalette;
	GUIPenSettings myPenSettings;
	GUITurtleState myTurtleState;
	ResourceBundle myResources;
	private CanvasMain myCanvas;
	
	public CanvasRight(ResourceBundle myResources, CanvasMain myCanvas) {
		this.myResources = myResources;
		this.myCanvas = myCanvas;
		initializeEnvironment();
	}
	
	private void initializeEnvironment(){
		myBackgroundPalette = new GUIComboBoxColorB(myCanvas, myResources, 
				myResources.getString("BackgroundColorPalettePromptText"),
				myResources.getString("DefaultBackgroundColors"));
		myPenPalette = new GUIComboBoxColorP(myCanvas, myResources, 
				myResources.getString("PenColorPalettePromptText"), 
				myResources.getString("DefaultPenColors"));
		myImagePalette = new GUIComboBoxImages(myCanvas, myResources, myResources.getString("ImageComboBoxPromptText"));
		myPenSettings = new GUIPenSettings(myResources, myCanvas);
		myTurtleState = new GUITurtleState(myResources, 
				new GUILabeled(myResources, myResources.getString("TurtleLocation")),
				new GUILabeled(myResources, myResources.getString("TurtleHeading")), 
				new GUILabeled(myResources, myResources.getString("TurtlePen")),
				new GUILabeled(myResources, myResources.getString("TurtleActive")));
	}
	/**
	 * Returns VBox containing ComboBoxes for background color palette, pen color palette, 
	 * image palette, pen settings, and view of turtle state.
	 */
	public Node createNode() {
		VBox vbox = new VBox();
		vbox.getChildren().addAll(myBackgroundPalette.createNode(), myPenPalette.createNode(), myImagePalette.createNode(),
				myPenSettings.createNode(), myTurtleState.createNode());
		return vbox;
	}
	/**
	 * Return current set of colors in pen color palette. 
	 * @return
	 */
	public List<String> getPenPalette(){
		return myPenPalette.getOptionsList();
	}
	/**
	 * Return current set of colors in background color palette. 
	 * @return
	 */
	public List<String> getBackgroundPalette(){
		return myBackgroundPalette.getOptionsList();
	}
	/**
	 * Return current set of images in image palette. 
	 * @return
	 */
	public List<String> getImagePalette(){
		return myImagePalette.getOptionsList();
	}
	/**
	 * Change color and given index in both background and pen palettes to the given RGB color.
	 * @param RGB
	 * @param index
	 */
	public void setPalettes(String RGB, int index){
		myBackgroundPalette.changePalette(RGB, index);
		myPenPalette.changePalette(RGB, index);
	}
	/**
	 * Set turtle state viewer to current state (location, direction, pen status, active status) of given turtle. 
	 * @param turtle
	 */
	public void showTurtleState(Turtle turtle){
		myTurtleState.showTurtleState(turtle);
	}

}
