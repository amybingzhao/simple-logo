package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Turtle;

/**
 * This class is the only external-facing back end class. It facilitates the interaction between the front end and back end
 * by processing the commands inputed by the user in the front end.
 * @author amyzhao
 *
 */
public class Controller {
	
	private Parser myParser;
	private List<Turtle> myTurtles;
	private List<String> myCommandHistory;
	private int myCanvasWidth;
	private int myCanvasHeight;

	public Controller(int width, int height){

        myTurtles = new ArrayList<Turtle>();
        myCommandHistory = new ArrayList<String>();
        myParser = new Parser();
        myCanvasWidth = width;
        myCanvasHeight = height;
    }

	/**
	 * Initializes the controller.
	 */
	public void init(int canvasHeight, int canvasWidth) {
		
	}
	
	/**
	 * Processes the command.
	 * @param s: String inputed by user to the command line.
	 */
	public void processCommand(String command) {
		
	}
	
	public void addCommandToHistory(String command) {
		
	}
	
	public List<String> getCommandHistory() {
		return myCommandHistory;
	}
	
}
