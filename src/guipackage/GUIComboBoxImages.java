package guipackage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * ComboBox with palette of images that the user can choose from for the Turtle.
 * @author AnnieTang
 *
 */
public class GUIComboBoxImages extends GUIComboBox {
	private Map<String, ImageView> imageMap;
	private List<String> imageNames;
	private static final int STANDARD_IMAGE_HEIGHT = 20;
	private static final String IMAGE_RESOURCE = "Images";
	
	public GUIComboBoxImages(GUICanvas canvas, ResourceBundle myResources, String promptText) {
		super(canvas, myResources, promptText);
		imageMap = new HashMap<>();
		imageNames = new ArrayList<>();
		fillImageNames();
		fillImageMap();
	}

	private void fillImageNames(){
		File imageDir = new File(IMAGE_RESOURCE);
		for(File imageFile: imageDir.listFiles()){
			imageNames.add(imageFile.getName());
		}
	}
	
	private void fillImageMap(){
		for(String imageName: imageNames){
			Image image = new Image(getClass().getClassLoader().getResourceAsStream(imageName));
			ImageView imageView = new ImageView(image);
	        imageView.setPreserveRatio(true);
	        imageView.setFitHeight(STANDARD_IMAGE_HEIGHT);
			imageMap.put(imageName, imageView);
		}
	}
	
	@Override
	protected Node getNodeForBox(String item){
        return imageMap.get(item);
	}
	
	@Override
	protected void setButtonAction() {
		comboButton.setOnAction(event -> {
			Image image = new Image(getClass().getClassLoader().getResourceAsStream(comboBox.getValue()));
			canvas.getTurtleImageView().setTurtleShape(image, comboBox.getValue());
			canvas.updateTurtleImageView();
		});
	}

	@Override
	protected List<String> optionsList() {
		return imageNames;
	}
	
	public List<String> getPalette(){
		return imageNames;
	}

}
