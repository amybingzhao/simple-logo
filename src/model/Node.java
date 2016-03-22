// This entire file is part of my masterpiece.
// Amy Zhao

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
     * Initializes the node's list of children.
     */
    public Node() {
        myChildren = new ArrayList<>();
    }

    /**
     * Adds a child node to the node's list.
     * @param child: node representing one of the current node's parameters.
     */
    public void addChild(Node child) {
    	if (child != null) {
    		myChildren.add(child);
    	}
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
     * Combines the values that each child node evaluates to.
     * @param val: starting value.
     * @param commandDict: command dictionary for current workspace.
     * @param varDict: variable dictionary for current workspace.
     * @return resultant value of combining child nodes' values.
     * @throws ClassNotFoundException
     */
    protected double combineAllChildValues(double val, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
		for (int i = 0; i < myChildren.size(); i++) {
			val = addNextChildValue(val, myChildren.get(i), commandDict, varDict);
		}
		return val;
    }
    
    /**
     * Default operation for combining child values (sums them).
     * @param val: starting val.
     * @param child: child to be combined.
     * @param commandDict: command dictionary for current workspace.
     * @param varDict: variable dictionary for current workspace.
     * @return sum of starting val and child val.
     * @throws ClassNotFoundException
     */
    protected double addNextChildValue(double val, IFunctions child, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
        return val + child.interpret(commandDict, varDict);
    }
    
    /**
     * Returns string representation of a node's children.
     * @return string representation of a node's children.
     */
    protected String childrenToString() {
    	StringBuilder sb = new StringBuilder(); 
    	for (int i = 0; i < myChildren.size(); i++) {
    		sb.append(myChildren.get(i).toString());
    		sb.append(" ");
    	}
    	return sb.toString();
    }
}
