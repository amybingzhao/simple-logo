package guipackage;


import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Turtle;

public class GUICanvasTurtle {
	private static final int TURTLE_SIZE = 20;
	private Group root;
	
	public GUICanvasTurtle(Group root) {
		this.root = root;
	}
	
	public Group getGroup(){
		return root;
	}
	
	public void removeTurtleImageView(Turtle turtle){
		root.getChildren().remove(turtle.getImageView());
	}
	
	public void createImageViewForTurtle(Turtle turtle, double x, double y, GUICanvasRight canvasRight, Image newShape){
		ImageView turtleImageView = new ImageView(newShape);
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

	public void updateImageView(ImageView imageView, double x, double y, double rotation, Image newShape){
		imageView.setX(x);
		imageView.setY(y);
		imageView.setRotate(rotation);
		imageView.setImage(newShape);
	}
}
