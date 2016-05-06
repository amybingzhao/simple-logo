/**
 * Modified for VOOGASalad addition
 */
package guipackage;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.image.Image;
import model.Turtle;
/**
 * Turtle ImageView component of the main GUICanvas
 * @author AnnieTang
 *
 */
public class CanvasImageManager {
	private static final String DEFAULT_TURTLE = "tortoise.png";
	private static final int TURTLE_SIZE = 25;
	private Group myRoot;
	private List<String> myImagePalette;
	private String myTurtleImageName;
	private int myTurtleImageIndex;
	private boolean showInactive;
	private CanvasMain myCanvas; 
	
	public CanvasImageManager(Group root, CanvasMain myCanvas) {
		this.myRoot = root;
		this.myCanvas = myCanvas;
		myTurtleImageName = DEFAULT_TURTLE;
		myTurtleImageIndex = 0;
		showInactive = true;
	}
	/**
	 * Places ImageView of given turtle onto the canvas. 
	 * @param turtle
	 * @param x
	 * @param y
	 * @param canvasRight
	 */
	protected void createImageViewForTurtle(Turtle turtle, double x, double y, CanvasRight canvasRight){
		turtle.getImageView().setFitHeight(TURTLE_SIZE);
		turtle.getImageView().setPreserveRatio(true);
		turtle.getImageView().setX(x);
		turtle.getImageView().setY(y);
		turtle.getImageView().setOnMouseEntered(event -> {
				 canvasRight.showTurtleState(turtle);
		});
		turtle.getImageView().setOnMouseClicked(event -> {
			turtle.setActive(!turtle.isActive());
			if(!showInactive){
				removeInactive();
			}
		});
		myRoot.getChildren().add(turtle.getImageView());
	}
	/**
	 * Updates coordinates, rotation, and image of given ImageView.
	 * @param imageView
	 * @param x
	 * @param y
	 * @param rotation
	 * @param newImage
	 */
	protected void updateImageView(Turtle turtle, double x, double y, double rotation, Image newImage){
		turtle.getImageView().setX(x);
		turtle.getImageView().setX(x);
		turtle.getImageView().setY(y);
		turtle.getImageView().setImage(newImage);
		turtle.getImageView().setRotate(rotation);
	}
	
	protected void updateImageViewLocation(Turtle turtle, double x, double y, Image newImage) {
		turtle.getImageView().setX(x);
		turtle.getImageView().setY(y);
		turtle.getImageView().setImage(newImage);
	}
	
	/**
	 * Set current palette of images to given palette.
	 * @param palette
	 */
	protected void setMyImagePalette(List<String> palette){
		this.myImagePalette = palette;
	}
	
	/**
	 * Sets Turtle shape/image based on index within palette.
	 * @param index of image in palette.
	 */
	public void setTurtleImage(int index) {
		myTurtleImageIndex = index;
		String imageName = myImagePalette.get(index);
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(imageName));
		setTurtleImage(image, imageName);
	}
	
	/**
	 * Sets user-inputed image as the Canvas turtle.
	 * @param Image
	 */
	public void setTurtleImage(Image image, String imageName){
		myTurtleImageName = imageName;
		for(String turtleName: myImagePalette){
			if(turtleName.equals(imageName)){
				myTurtleImageIndex = myImagePalette.indexOf(turtleName);
			}
		}
		for(Turtle turtle: myCanvas.getMyTurtles().keySet()){
			turtle.setImage(image);
			turtle.getImageView().setImage(image);
			
		}
	}
	
	/**
	 * returns current turtle image filename
	 * @return
	 */
	public String getTurtleImageName(){
		return myTurtleImageName;
	}
	
	/**
	 * Returns current index of shape/image of turtle;
	 */
	public int getTurtleImageIndex() {
		return myTurtleImageIndex;
	}
	/**
	 * Based on given visibility string (true/false), either show inactive turtles or hide them. 
	 * @param visibility
	 */
	protected void setVisibility(String visibility){
		showInactive = Boolean.parseBoolean(visibility);
		if (showInactive) {
			showInactive();
		}
		else {
			removeInactive();
		}
	}	
	/**
	 * Show all turtles on canvas, including inactive.
	 */
	private void showInactive(){
		for(Turtle turtle: myCanvas.getMyTurtles().keySet()){
			if(!myRoot.getChildren().contains(turtle.getImageView())){
				myRoot.getChildren().add(turtle.getImageView());
			}
		}
	}
	/**
	 * Hide inactive turtles on canvas.
	 */
	private void removeInactive(){
		for(Turtle turtle:myCanvas.getMyTurtles().keySet()){
			if(!turtle.isActive()){
				myRoot.getChildren().remove(turtle.getImageView());
			}
		}
	}
}
