// This entire file is part of my masterpiece.
// Amy Zhao

// The TreeNode class is an abstract base class for all of the SLogo functions. It was refactored to be named TreeNode instead of Node to avoid
// confusion and conflict with the JavaFX node class. It implements the IFunctions interface, and thus by extension, all of the SLogo functions
// implement the IFunctions interface.

// The use of this inheritance hierarchy allowed for significant flexibility in terms of adding new SLogo functions, and also allowed us
// to build a tree of Nodes for ease of executing the user-entered commands once they'd been parsed. This makes it open to extension since
// a new SLogo function can be added simply by creating a subclass of this hierarchy, which will ensure that it can be parsed into a node of
// the expression tree and thus interpreted and executed, and it also makes it closed to modifications in that it restricts SLogo functions
// to being implemented as nodes of a tree with only IFunctions as their children.

// The code in this class is also very concise and well-documented. The short list of instance variables are all private, and interfaces 
// are used to improve clarity. Additionally, the setter for adding a child to myChildren (addChild()), contains checks for bad input, increasing
// its functionality beyond just setting a value, and the childrenToString() method uses a StringBuffer to improve efficiency.

package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Node object to make expression tree.
 * @author amyzhao
 *
 */
public abstract class TreeNode implements IFunctions {
    private List<IFunctions> myChildren;
    private int numChildrenNeeded;

    /**
     * Initializes the node's list of children.
     */
    public TreeNode() {
        myChildren = new ArrayList<>();
    }

    /**
     * Adds a child node to the node's list.
     * @param child: node representing one of the current node's parameters.
     */
    public void addChild(TreeNode child) {
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
