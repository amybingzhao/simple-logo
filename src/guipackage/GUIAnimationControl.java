package guipackage;

import java.util.ResourceBundle;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class GUIAnimationControl implements IGUIObject {
	private static final int PADDING = 10;
	private static final int VBOX_SPACING = 5;
	private GUICanvas myCanvas;
	private ResourceBundle myResources;
	
	public GUIAnimationControl(ResourceBundle r, GUICanvas canvas) {
		myResources = r;
		myCanvas = canvas;
	}

	@Override
	public Node createNode() {
		VBox sliderBox = new VBox(VBOX_SPACING);
		
		Label sliderLabel = new Label(myResources.getString("AnimationSlider"));
		Slider animationSpeed = new Slider();
		animationSpeed.setMin(0);
		animationSpeed.setMax(1.6);
		animationSpeed.setValue(1);
		animationSpeed.setMajorTickUnit(0.2f);
		animationSpeed.setShowTickMarks(true);
		animationSpeed.setShowTickLabels(true);
		
		animationSpeed.valueProperty().addListener(event -> setSpeed(animationSpeed.getValue()));
		
		sliderBox.getChildren().addAll(sliderLabel, animationSpeed);
		sliderBox.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		return sliderBox;
	}
	
	private void setSpeed(double value) {
		myCanvas.getAnimation().setSpeed(value);
	}

	@Override
	public void updateNode() {
		// TODO Auto-generated method stub

	}

}
