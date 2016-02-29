package GUIPackage;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
/**
 * Area beneath command line where solutions to mathematical inputs will be printed. 
 * @author AnnieTang
 *
 */
public class GUIObjectLabeled implements GUIObject {
	private static final int PADDING = 10;
	private Labeled label;
	
	public GUIObjectLabeled() {
	}

	@Override
	public Node createNode() {
		label = new Label("Output:");
		label.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		return label;
	}

	public void setOutput(int mathResult){
		label.setText(Integer.toString(mathResult));
	}
	
	@Override
	public void updateNode() {
	}
}
