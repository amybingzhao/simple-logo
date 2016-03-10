package guipackage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
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
		imageMap = new HashMap<String, ImageView>();
		imageNames = new ArrayList<String>();
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
	protected void setCellFactory(){
		 comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
		     @Override public ListCell<String> call(ListView<String> p) {
		         return new ListCell<String>() {		             
		             @Override protected void updateItem(String imageName, boolean empty) {
		                 super.updateItem(imageName, empty);
		                 if (imageName == null || empty) {
		                     setGraphic(null);
		                 } else {
		                	 HBox hbox = new HBox();
		                	 Label imageText = new Label(imageName);
		                     ImageView imageView = imageMap.get(imageName);
		                     hbox.getChildren().addAll(imageView, imageText);
		                     setGraphic(hbox);
		                 }
		            }
		       };
		   }
		});
	}
	
	@Override
	protected void setButtonAction() {
		comboButton.setOnAction(event -> {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(comboBox.getValue()));
		canvas.setTurtleShape(image, comboBox.getValue());
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
