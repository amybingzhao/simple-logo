package GUIPackage;
import Controller.Controller;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ResourceBundle;

public class GUICommandLine {
	private Controller myController;
	private ResourceBundle myResources;
	private int myX;
	private int myY;
	
	private Label commandLabel;
	private TextField commandInputLine;
	private Button runButton;
	
	private static final int COMMAND_LINE_SPACING = 5;
	private static final double PADDING_TOP = 0;
	private static final double PADDING_RIGHT = 10;
	private static final double PADDING_BOTTOM = 10;
	private static final double PADDING_LEFT = 10;
	
	public GUICommandLine(Controller c, ResourceBundle r, String xPosString, String yPosString) {
		myController = c;
		myResources = r;
		myX = Integer.valueOf(myResources.getString(xPosString));
		myY = Integer.valueOf(myResources.getString(yPosString));
	}
	
	public Node createNode() {
		commandLabel = new Label(myResources.getString("EnterCommand"));
		commandInputLine = new TextField();
		runButton = new Button(myResources.getString("Run"));
		runButton.setOnAction(evt -> runCommand());
		
		VBox commandLine = new VBox();
		commandLine.getChildren().addAll(commandLabel, commandInputLine, runButton);
		commandLine.setSpacing(COMMAND_LINE_SPACING);
		//TODO: remove magic numbers 
		commandLine.setPadding(new Insets(PADDING_TOP, PADDING_RIGHT, PADDING_BOTTOM, PADDING_LEFT));
		
		return commandLine;
	}
	
	public void runCommand() {
		try {
			myController.processCommand(commandInputLine.getText());
		}
		catch (ClassNotFoundException e) {
			//TODO: Find out what exceptions back end throws
			//do something with exception
		}
		clearTextField();
	}
	
	public void clearTextField() {
		commandInputLine.clear();
	}
	
	public int getXPos() {
		return myX;
	}

	public int getYPos() {
		return myY;
	}
}
