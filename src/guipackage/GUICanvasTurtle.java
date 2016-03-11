package guipackage;


import java.util.List;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Turtle;

public class GUICanvasTurtle {
	private static final String DEFAULT_TURTLE = "turtle_outline.png";
	private static final int TURTLE_SIZE = 20;
	private Group root;
	private List<String> myImagePalette;
	private Image myTurtleShape;
	private String myTurtleShapeName;
	private int myTurtleShapeIndex;
	
	public GUICanvasTurtle(Group root) {
		this.root = root;
		myTurtleShape = new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_TURTLE));
		myTurtleShapeName = DEFAULT_TURTLE;
		myTurtleShapeIndex = 0;
	}
	
	protected Group getGroup(){
		return root;
	}
	
	protected void removeTurtleImageView(Turtle turtle){
		root.getChildren().remove(turtle.getImageView());
	}
	
	protected void createImageViewForTurtle(Turtle turtle, double x, double y, GUICanvasRight canvasRight){
		ImageView turtleImageView = new ImageView(myTurtleShape);
		turtleImageView.setFitHeight(TURTLE_SIZE);
		turtleImageView.setPreserveRatio(true);
		turtleImageView.setX(x);
		turtleImageView.setY(y);
		turtleImageView.setOnMouseEntered(event -> {
				 canvasRight.showTurtleState(turtle);
		});
		turtleImageView.setOnMouseClicked(event -> {
			turtle.setActive(!turtle.isActive());
		});
		turtle.setImageView(turtleImageView);
		root.getChildren().add(turtle.getImageView());
	}

	protected void updateImageView(ImageView imageView, double x, double y, double rotation, Image newShape){
		imageView.setX(x);
		imageView.setY(y);
		imageView.setRotate(rotation);
		imageView.setImage(newShape);
	}
	
	protected void setMyImagePalette(List<String> palette){
		this.myImagePalette = palette;
	}
	
	protected Image getTurtleShape(){
		return myTurtleShape;
	}
	
	/**
	 * Sets Turtle shape/image based on index within palette.
	 * @param index of image in palette.
	 */
	public void setTurtleShape(int index) {
		myTurtleShapeIndex = index;
		String imageName = myImagePalette.get(index);
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(imageName));
		setTurtleShape(image, imageName);
	}
	
	/**
	 * Sets user-inputed image as the Canvas turtle.
	 * @param Image
	 */
	public void setTurtleShape(Image image, String imageName){
		System.out.println(imageName);
		myTurtleShape = image;
		myTurtleShapeName = imageName;
		for(String turtleName:myImagePalette){
			if(turtleName.equals(imageName)){
				myTurtleShapeIndex = myImagePalette.indexOf(turtleName);
			}
		}
	}
	
	/**
	 * returns current turtle image filename
	 * @return
	 */
	public String getTurtleImageName(){
		return myTurtleShapeName;
	}
	
	/**
	 * Returns current index of shape/image of turtle;
	 */
	public int getTurtleShapeIndex() {
		return myTurtleShapeIndex;
	}
	
}
