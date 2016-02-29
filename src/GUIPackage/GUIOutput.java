package GUIPackage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.HBox;

public class GUIOutput{
	private static final int PADDING = 10;
	private Labeled outputLabel;
	private Labeled outputText;
	
	public GUIOutput() {
	}
	
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
	
	public void setOutputText(String val){
		outputText.setText(val);
	}
	
	public String getOutputText(){
		return outputText.getText();
	}

}
