package guipackage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.HBox;

/**
 * Creates the Output label on the GUI.
 * @author AnnieTang
 *
 */
public class GUIOutput{
	private static final int PADDING = 10;
	private Labeled outputLabel;
	private Labeled outputText;
	
	/**
	 * Creates Node for the output element of the GUI.
	 * @return Output HBox Node
	 */
	public Node createNode(){
		HBox hbox = new HBox();
		outputLabel = new Label("Output: ");
		outputLabel.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		outputText = new Label();
		outputText.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		hbox.getChildren().addAll(outputLabel, outputText);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		return hbox;
	}
	
	/**
	 * sets the output text as the passed in parameter.
	 * @param val
	 */
	public void setOutputText(String val){
		outputText.setText(val);
	}
	
	/**
	 * Returns the string within the output.
	 * @return output text String
	 */
	protected String getOutputText(){
		return outputText.getText();
	}

}
