package guipackage;

import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Turtle;

public class TurtleCell extends ListCell<Turtle>{
	
	protected void updateItem (Turtle item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
        	ImageView image = createImageView(item);
            setText(String.valueOf(item.getID()));
            setGraphic(image);
        }
    }

    private ImageView createImageView (Turtle turtle) {
        ImageView myImage = new ImageView(turtle.getImageView().getImage());
        myImage.setFitHeight(20);
        myImage.setPreserveRatio(true);
        return myImage;
    }
}
