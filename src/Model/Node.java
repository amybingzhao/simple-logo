package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Node implements LogoFunctions {
    private List<Node> myChildren;
    private int numChildrenNeeded;
    private Turtle myTurtle;

    public Node() {
        myChildren = new ArrayList<>();
        myTurtle = null;
    }

    public void addChild(Node child) {
        myChildren.add(child);
    }

    public int getNumChildrenNeeded() {
        return numChildrenNeeded;
    }

    public void setNumChildrenNeeded(int n) {
        numChildrenNeeded = n;
    }

    public List<Node> getChildren() {
        return myChildren;
    }

    public void addTurtle(Turtle turtle) {
        myTurtle = turtle;
    }

    public abstract double interpret();

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
