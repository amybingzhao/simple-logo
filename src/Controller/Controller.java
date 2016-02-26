package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Node;
import Model.Turtle;
import Model.Variable;

/**
 * This class is the only external-facing back end class. It facilitates the interaction between the front end and back end
 * by processing the commands inputed by the user in the front end.
 *
 * @author amyzhao
 * @author blakekaplan
 */
public class Controller {

    private static final String SYNTAX_RESOURCE = "resources/languages/Syntax";
    private static final String LANGUAGE_RESOURCE = "resources/languages/English";
    private Parser myParser;
    private List<Turtle> myTurtles;
    private List<String> myCommandHistory;
    private int myCanvasWidth;
    private int myCanvasHeight;
    private Turtle myTurtle;

    /**
     * Initializes the controller.
     */
    public void init(int canvasHeight, int canvasWidth) {
        myCanvasWidth = canvasWidth;
        myCanvasHeight = canvasHeight;
        myParser = new Parser();
        myParser.addPatterns(LANGUAGE_RESOURCE);
        myParser.addPatterns(SYNTAX_RESOURCE);
        myCommandHistory = new ArrayList<String>();
        myTurtles = new ArrayList<Turtle>();
        myTurtle = new Turtle();
    }

    /**
     * Processes the command.
     *
     * @param command: String inputed by user to the command line.
     * @throws ClassNotFoundException
     */
    public void processCommand(String command) throws ClassNotFoundException {
        List<Node> commands = myParser.createCommandTree(command, myTurtle);
        executeCommandTree(commands);
    }

    private void executeCommandTree(List<Node> headNodes) {
        for (int i = 0; i < headNodes.size(); i++) {
            Node head = headNodes.get(i);
            System.out.println(head.toString());
            //head.interpret();
            System.out.println("result: " + Double.toString(head.interpret()));
            System.out.println(myTurtle.printPosition());
            addCommandToHistory(head.toString());
        }
    }


    private void addCommandToHistory(String command) {
        myCommandHistory.add(command);
    }

    public List<String> getCommandHistory() {
        return myCommandHistory;
    }

}
