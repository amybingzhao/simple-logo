package GUIPackage;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class GUI implements GUIInterface {
	private Scene myScene;
	private List<Node> myNodeList;
	private GridPane myRoot;
	private GUIObjectFactory myFactory;
	
	public GUI () {
		
	}
	
	public Scene createScene() {
		myRoot = new GridPane();
		
		
		
		return myScene;
	}
	
	public void addNodes() {
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void notifyAllObservers() {
		// TODO Auto-generated method stub

	}

}
