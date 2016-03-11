package guipackage;

import java.util.ResourceBundle;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GUIPenSettings implements IGUIObject{
	private static final int PADDING = 10;
	private static final int BOX_SPACING = 10;
	private ResourceBundle myResources;
	private GUICanvas myCanvas;
	private GUICanvasPen myPen;
	private Label upDownLabel;
	private ToggleGroup penUpDownGroup;
	private RadioButton penUp;
	private RadioButton penDown;
	private Label penTypeLabel;
	private ToggleGroup penTypeGroup;
	private RadioButton penSolid;
	private RadioButton penDashed;
	private RadioButton penDotted;
	private Label penLabel;
	private TextField penThickness;
	private Button setThickness;
	
	public GUIPenSettings(ResourceBundle r, GUICanvas c) {
		myResources = r;
		myCanvas = c;
		myPen = myCanvas.getPen();
	}
	@Override
	public Node createNode() {
		VBox vboxToReturn = new VBox(BOX_SPACING);
		VBox vbox1 = new VBox(BOX_SPACING);
		VBox vbox2 = new VBox(BOX_SPACING);
		HBox hbox = new HBox(BOX_SPACING);
		setPenUpDownNodes();
		setPenTypeNodes();
		setThicknessNodes();
		
		vbox1.getChildren().addAll(upDownLabel, penUp, penDown);
		vbox2.getChildren().addAll(penTypeLabel, penSolid, 
				penDashed, penDotted);
		hbox.getChildren().addAll(vbox1,vbox2);
		vboxToReturn.getChildren().addAll(hbox, penLabel, penThickness, setThickness);
		
		for(Node child: vboxToReturn.getChildren()){
			child.setStyle(myResources.getString("FontStyle"));
		}
		
		vboxToReturn.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		return vboxToReturn;
	}
	
	private void setPenUpDownNodes() {
		upDownLabel = new Label(myResources.getString("UpDownLabel"));
		
		penUpDownGroup = new ToggleGroup();
		
		penUp = new RadioButton(myResources.getString("PenUp"));
		penUp.setToggleGroup(penUpDownGroup);
		penUp.setSelected(true);
		penUp.setUserData(myResources.getString("PenUp"));
		
		penDown = new RadioButton(myResources.getString("PenDown"));
		penDown.setToggleGroup(penUpDownGroup);
		penDown.setUserData(myResources.getString("PenDown"));
		
		penUpDownGroup.selectedToggleProperty().addListener(
				e -> myCanvas.setTurtlePenStatus(penUpDownGroup.getSelectedToggle().getUserData().toString()));
	}
	
	private void setPenTypeNodes() {
		penTypeLabel = new Label(myResources.getString("PenType"));
		
		penTypeGroup = new ToggleGroup();
		
		penSolid = new RadioButton(myResources.getString("SolidPen"));
		penSolid.setToggleGroup(penTypeGroup);
		penSolid.setSelected(true);
		penSolid.setUserData(myResources.getString("SolidPen"));
		
		penDashed = new RadioButton(myResources.getString("DashedPen"));
		penDashed.setToggleGroup(penTypeGroup);
		penDashed.setUserData(myResources.getString("DashedPen"));
		
		penDotted = new RadioButton(myResources.getString("DottedPen"));
		penDotted.setToggleGroup(penTypeGroup);
		penDotted.setUserData(myResources.getString("DottedPen"));
		
		penTypeGroup.selectedToggleProperty().addListener(
				e -> myPen.setMyPenType(penTypeGroup.getSelectedToggle().getUserData().toString()));
	}
	
	private void setThicknessNodes() {
		penLabel = new Label(myResources.getString("ThicknessField"));
		
		penThickness = new TextField();
		setThickness = new Button(myResources.getString("SetThickness"));
		setThickness.setOnAction(event -> myPen.setMyPenSize(Double.valueOf(penThickness.getText())));
	}

	@Override
	public void updateNode() {
		// TODO Auto-generated method stub
		
	}

}
