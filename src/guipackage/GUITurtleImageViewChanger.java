package guipackage;

import java.io.File;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Turtle;

public class GUITurtleImageViewChanger implements IGUIObject {

	private static final int TOP_PADDING = 10;
	private static final int RIGHT_PADDING = 0;
	private static final int BOTTOM_PADDING = 0;
	private static final int LEFT_PADDING = 0;
	private static final int PANEL_SPACING = 5;
	
	private ResourceBundle myResources;
	private GUICanvas myCanvas;
	private ListView<Turtle> myTurtleList;
    private ObservableList<Turtle> myTurtles;
    private Stage myStage;

	public GUITurtleImageViewChanger(ResourceBundle r, GUICanvas canvas) {
		myResources = r;
		myCanvas = canvas;
		myTurtles = FXCollections.observableArrayList();
		myStage = new Stage(); 
	}
	
	@Override
	public Node createNode() {
		VBox box = new VBox(PANEL_SPACING);
		Label label = new Label(myResources.getString("UpdateImage"));
        myTurtleList = new ListView<>();
        myTurtleList.setItems(myTurtles);
        myTurtleList.setCellFactory(cellFactory -> new TurtleCell());
        myTurtleList.setOnMouseClicked(e -> {
            loadInImage(myTurtleList.getSelectionModel().getSelectedItem());
        });
        myTurtleList.setPrefHeight(Double.valueOf(myResources.getString("ListViewHeight")));
        updateNode();
        box.getChildren().addAll(label, myTurtleList);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        VBox.setVgrow(myTurtleList, Priority.ALWAYS);
        return box;
	}

	@Override
	public void updateNode() {
		updateTurtles();		
	}
	
	public void updateTurtles() {
		myTurtles.clear();
		for (Turtle t: myCanvas.getTurtles()) {
			myTurtles.add(t);
		}
	}
	
	private void loadInImage(Turtle turtle) {
		myCanvas.setUpdateAllTurtles(false);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(myResources.getString("ChooseFile"));
		File selectedFile = fileChooser.showOpenDialog(myStage);
		turtle.getImageView().setImage(new Image(selectedFile.toURI().toString()));
		updateTurtles();
	}
}
