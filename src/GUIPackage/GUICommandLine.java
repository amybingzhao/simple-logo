package GUIPackage;
import Controller.Controller;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.ResourceBundle;

public class GUICommandLine {
	private Controller myController;
	private ResourceBundle myResources;
	private TabMainScreen myGUI;
	private int myX;
	private int myY;
	
	private Label commandLabel;
	private TextArea commandInputLine;
	private Button runButton;
	
	private static final int COMMAND_LINE_SPACING = 5;
	private static final double PADDING_TOP = 0;
	private static final double PADDING_RIGHT = 10;
	private static final double PADDING_BOTTOM = 10;
	private static final double PADDING_LEFT = 10;
	
	protected GUICommandLine(Controller c, ResourceBundle r, TabMainScreen t) {
		myController = c;
		myResources = r;
		myGUI = t;
//		myX = Integer.valueOf(myResources.getString(xPosString));
//		myY = Integer.valueOf(myResources.getString(yPosString));
	}
	
	protected Node createNode() {
		commandLabel = new Label(myResources.getString("Command"));
		commandInputLine = new TextArea();
		commandInputLine.setPrefRowCount(3);
		runButton = new Button(myResources.getString("Run"));
		runButton.setOnAction(evt -> runCommand());
		
		VBox commandLine = new VBox();
		commandLine.getChildren().addAll(commandLabel, commandInputLine, runButton);
		commandLine.setSpacing(COMMAND_LINE_SPACING);
		commandLine.setPadding(new Insets(PADDING_TOP, PADDING_RIGHT, PADDING_BOTTOM, PADDING_LEFT));
		
		return commandLine;
	}
	
	private void runCommand() {
		try {
			myController.processCommand(commandInputLine.getText());
			myGUI.updateGUI();
		}
		catch (ClassNotFoundException e) {
			//TODO: Find out what exceptions back end throws
			//do something with exception
		}
		clearTextField();
	}
	
	private void clearTextField() {
		commandInputLine.clear();
	}
	
	protected int getXPos() {
		return myX;
	}

	protected int getYPos() {
		return myY;
	}
}
