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
public class GUICanvasRight implements IGUIObject {
	private GUIComboBoxColor myBackgroundPalette;
	private GUIComboBoxColor myPenPalette;
	private GUIComboBoxImages myImagePalette;
	private GUIPenSettings myPenSettings;
	private GUITurtleState myTurtleState;
	private ResourceBundle myResources;
	
	public GUICanvasRight(ResourceBundle myResources, GUIComboBoxColor background, GUIComboBoxColor pen, 
			GUIComboBoxImages images, GUIPenSettings penSettings, GUITurtleState turtleState) {
		this.myResources = myResources;
		this.myBackgroundPalette = background;
		this.myPenPalette = pen;
		this.myImagePalette = images;
		this.myPenSettings = penSettings;
		this.myTurtleState = turtleState;
	}

	@Override
	public Node createNode() {
		VBox vbox = new VBox();
		vbox.getChildren().addAll(myBackgroundPalette.createNode(), myPenPalette.createNode(), myImagePalette.createNode(),
				myPenSettings.createNode(), myTurtleState.createNode());
		return vbox;
	}

	@Override
	public void updateNode() {
	}
	
	public List<String> getPenPalette(){
		return myPenPalette.getOptionsList();
	}
	
	public List<String> getBackgroundPalette(){
		return myBackgroundPalette.getOptionsList();
	}
	
	public List<String> getImagePalette(){
		return myImagePalette.getOptionsList();
	}
	
	public void changePalettes(String RGB, int index){
		myBackgroundPalette.changePalette(RGB, index);
		myPenPalette.changePalette(RGB, index);
	}
	
	public void showTurtleState(Turtle turtle){
		myTurtleState.showTurtleState(turtle);
	}

}
