// This entire file is part of my masterpiece.
// David Yang

/**
 * I chose to put this interface in the code masterpiece because it is the
 * central piece of the front end design. This API makes it easy for future
 * developers to add additional GUI elements to the slogo window. 
 */

package guipackage;
import javafx.scene.Node;

/**
 * This interface is the core of the internal API. In order to add new features, you
 * can create a new class that implements this interface. Once the GUI knows to
 * create the new element in the GUIFactory, the new feature will essentially be added.
 *
 * @author David
 */
public interface IGUIObject {

    /**
     * This method creates the GUI element and passes it to the GUI class as a Node
     * type. All of the IGUIObject types will include this class because the TabMainScreen
     * class will create the Nodes from the IGUIObjects by calling this method.
     *
     */
    public Node createNode();

    /**
     * This method updates the Node based on new information. For example, the
     * environment should keep track of all the commands that the user has used
     * previously. Every time the user inputs a command, this method will be called
     * for the PreviousCommands object so that the GUI can show that that command
     * has been called.
     */
    public void updateNode();

}
