package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Node object to make expression tree.
 * @author amyzhao
 *
 */
public abstract class Node implements LogoFunctions {
    private List<Node> myChildren;
    private int numChildrenNeeded;
    private Turtle myTurtle;

    /**
     * Initializes the node's turtle and list of children nodes.
     */
    public Node() {
        myChildren = new ArrayList<>();
        myTurtle = null;
    }

    /**
     * Adds a child node to the node's list.
     * @param child: node representing one of the current node's parameters.
     */
    public void addChild(Node child) {
        myChildren.add(child);
    }

    /**
     * Gets the number of parameters the function needs.
     * @return number of parameters needed.
     */
    public int getNumChildrenNeeded() {
        return numChildrenNeeded;
    }

    /**
     * Sets the number of children the node needs to be interpreted correctly.
     * @param n: number of parameters the function needs. 
     */
    public void setNumChildrenNeeded(int n) {
        numChildrenNeeded = n;
    }

    /**
     * Gets the list of children nodes.
     * @return list of children nodes.
     */
    public List<Node> getChildren() {
        return myChildren;
    }

    /**
     * Adds a turtle to this node.
     * @param turtle: turtle to add.
     */
    public void addTurtle(Turtle turtle) {
        myTurtle = turtle;
    }

    /**
     * Interprets the function.
     */
    public abstract double interpret();

    /**
     * Gets this node's turtle.
     * @return the turtle assigned to this node.
     */
    protected Turtle getTurtle() {
        if (myTurtle != null) {
            return myTurtle;
        } else {
            //error
            return null;
        }
    }

    /**
	 * Returns the required user input for this command. 
	 */
    public abstract String toString();
}
