package GUIPackage;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
/**
 * Area beneath command line where caught exceptions will print out descriptive messages. 
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
		label = new Label("Welcome to SLogo! Look here for tips. ");
		label.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		return label;
	}

	public void setText(String errorMessage){
		label.setText(errorMessage);
	}
	
	@Override
	public void updateNode() {
	}
}
