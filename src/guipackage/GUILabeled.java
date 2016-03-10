package guipackage;

import java.util.ResourceBundle;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.HBox;
/**
 * Allows editable text to show up on console in various places. 
 * @author AnnieTang
 *
 */
public class GUILabeled implements IGUIObject {
	private static final int PADDING = 5;
	private Labeled outputLabel;
	private Labeled outputText;
	
	public GUILabeled(ResourceBundle myResources, String labelText) {
		outputLabel = new Label(labelText);
		outputText = new Label();
		
	}

	@Override
	public Node createNode() {
		HBox hbox = new HBox();
		outputLabel.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		outputText.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		hbox.getChildren().addAll(outputLabel, outputText);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		return hbox;
	}

	@Override
	public void updateNode() {
	}
	
	/**
	 * sets the output text as the passed in parameter.
	 * @param val
	 */
	public void setOutputText(String val){
		outputText.setText(val);
	}
}