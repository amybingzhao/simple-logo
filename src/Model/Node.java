package Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Node object to make expression tree.
 * @author amyzhao
 *
 */
public abstract class Node implements IFunctions {
    private List<Node> myChildren;
    private int numChildrenNeeded;
    private List<Turtle> myTurtles;

    /**
     * Initializes the node's turtle and list of children nodes.
     */
    public Node() {
        myChildren = new ArrayList<Node>();
        myTurtles = null;
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
     * Interprets the function.
     * @param commandDict
     * @param varDict
     */
    public abstract double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException;

    public void setTurtleList(List<Turtle> curTurtles) {
    	myTurtles = curTurtles;
    }
    /**
     * Gets this node's turtle.
     * @return the turtle assigned to this node.
     */
    protected List<Turtle> getActiveTurtles() {
    	List<Turtle> curTurtles = getTurtles();
        List<Turtle> activeTurtles = new ArrayList<Turtle>();
        for (int i = 0; i < curTurtles.size(); i++) {
        	if (curTurtles.get(i).isActive()) {
        		activeTurtles.add(curTurtles.get(i));
        	}
        }
        return activeTurtles;
    }
    
    
    public void createTurtle(double ID) {
    	Turtle turtle = new Turtle(ID);
		turtle.activate();
    	myTurtles.add(turtle);
    }
    
    public List<Turtle> getTurtles() {
    	if (myTurtles != null) {
    		if (myTurtles.isEmpty()) {
    			createTurtle(0);
    		}
    		return myTurtles;
    	}
    	return null;
    }
    
    public Turtle getTurtleByID(double ID) {
    	for (int i = 0; i < myTurtles.size(); i++) {
    		if (myTurtles.get(i).getID() == ID) {
    			return myTurtles.get(i);
    		}
    	}
    	return null;
    }
    
    public List<Double> createListFromCommandList(CommandList commandList, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
    	List<Double> list = new ArrayList<Double>();
    	for (int i = 0; i < commandList.getChildren().size(); i++) {
    		list.add(commandList.getChildren().get(i).interpret(commandDict, varDict));
    	}
    	return list;
    }
/*
    protected double applyToActiveTurtles(Class nodeClass, String methodName, Node obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	double ret = 0;
    	Class noparams[] = {};
		Method method = nodeClass.getDeclaredMethod(methodName, noparams);
    	for (int i = 0; i < myActiveTurtles.size(); i++) {
    		myActiveTurtle = myActiveTurtles.get(i);
    		method.invoke(obj, null);
    	}
    	return ret;
    }*/
    
    /**
	 * Returns the required user input for this command. 
	 */
    public abstract String toString();
}
