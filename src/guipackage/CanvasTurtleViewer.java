/**
 * Created for VOOGASalad addition
 */
package guipackage;


import java.util.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Turtle;
/**
 * For VOOGASalad addition: Add a new view that allows users to see the images of all of the turtles (active or not). 
 * Clicking on an image should let the user change that turtle's image. 
 * @author AnnieTang
 *
 */
public class CanvasTurtleViewer implements IGUIObject{
	private static final String TURTLE_LIST = "All Turtles:";
	private static final int FIT_HEIGHT = 30;
	private static final String PROMPT = "Choose image for selected turtle";
	private static final int PADDING = 10;
	private CanvasMain myCanvas;
	private VBox myTurtleList;
	private ResourceBundle myResources;
	private Map<ImageView, Turtle> newImageViewMap;
	
	public CanvasTurtleViewer(CanvasMain canvas, ResourceBundle myResources){
		this.myCanvas = canvas; 
		this.myResources = myResources; 
	}

	private void createTurtleList(){
		newImageViewMap = new HashMap<>();
		myTurtleList.getChildren().add(new Label(TURTLE_LIST));
		for(Turtle turtle: myCanvas.getMyTurtles().keySet()){
			ImageView iv = new ImageView(turtle.getImage());
			iv.setFitHeight(FIT_HEIGHT);
			iv.setPreserveRatio(true);
			newImageViewMap.put(iv, turtle);
			myTurtleList.getChildren().add(iv);
		}
	}
	
	private void setTurtleClickEvent(){
		for(ImageView imageView: newImageViewMap.keySet()){
			imageView.setOnMouseClicked(event -> {
				showPopUp(newImageViewMap.get(imageView));
			});
		}
	}
	
	private void showPopUp(Turtle turtle){
		Stage popupStage = new Stage(); 
		StackPane stackPane = new StackPane();
		GUIComboBoxTurtleViewer comboBox = new GUIComboBoxTurtleViewer(myCanvas, myResources, PROMPT,  turtle);
		stackPane.getChildren().add(comboBox.createNode());
		Scene popupScene = new Scene(stackPane); 
		popupStage.setScene(popupScene);
		popupStage.showAndWait();
		myCanvas.updateTurtleImageView();
	}
	
	@Override
	public Node createNode(){
		myTurtleList = new VBox(PADDING);
		myTurtleList.setPadding(new Insets(PADDING,PADDING,PADDING,PADDING));
		createTurtleList();
		setTurtleClickEvent();
		return myTurtleList;
	}

	@Override
	public void updateNode() {
		myTurtleList.getChildren().clear();
		createTurtleList();
		setTurtleClickEvent();
	}

}
