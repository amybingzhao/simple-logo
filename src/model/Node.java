package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Node object to make expression tree.
 * @author amyzhao
 *
 */
public abstract class Node implements IFunctions {
    private List<IFunctions> myChildren;
    private int numChildrenNeeded;

    /**
     * Initializes the node's turtle and list of children nodes.
     */
    public Node() {
        myChildren = new ArrayList<IFunctions>();
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
    public List<IFunctions> getChildren() {
        return myChildren;
    }

    /**
     * Interprets the function.
     * @param commandDict
     * @param varDict
     */
    public abstract double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException;

    
    
    public List<Double> createListFromCommandList(CommandList commandList, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
        List<Double> list = new ArrayList<Double>();
    	for (int i = 0; i < commandList.getChildren().size(); i++) {
    		list.add(commandList.getChildren().get(i).interpret(commandDict, varDict));
    	}
    	return list;
    }
    
    protected double applyChildren(double val, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
		for (int i = 0; i < myChildren.size(); i++) {
			val = addChildValue(val, myChildren.get(i), commandDict, varDict);
		}
		return val;
    }
    
    protected double addChildValue(double val, IFunctions child, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
        return val + child.interpret(commandDict, varDict);
    }
    
    protected String childrenToString() {
    	StringBuilder sb = new StringBuilder(); 
    	for (int i = 0; i < myChildren.size(); i++) {
    		sb.append(myChildren.get(i).toString());
    		sb.append(" ");
    	}
    	return sb.toString();
    }
    /**
	 * Returns the required user input for this command. 
	 */
    public abstract String toString();
}
