/**
 * Modified for VOOGASalad addition
 */
package guipackage;

import java.util.ResourceBundle;

import javafx.scene.image.Image;
import model.Turtle;

public class GUIComboBoxTurtleViewer extends GUIComboBoxImages {
	private Turtle myTurtle; 
	public GUIComboBoxTurtleViewer(CanvasMain canvas, ResourceBundle myResources, String promptText, Turtle myTurtle) {
		super(canvas, myResources, promptText);
		this.myTurtle = myTurtle;
	}

	/**
	 * On comboButton click, given turtle ImageView will be updated with new Image. 
	 */
	@Override
	protected void setButtonAction() {
		comboButton.setOnAction(event -> {
			Image image = new Image(getClass().getClassLoader().getResourceAsStream(comboBox.getValue()));
			myTurtle.setImage(image);
			myTurtle.getImageView().setImage(image);
			canvas.setCenterPane();
		});
	}
}
