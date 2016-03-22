// This entire file is part of my masterpiece.
// Amy Zhao

// This is a subclass to demonstrate the usage of the IFunctions interface in the interpreter pattern as well as the functionality of the Node
// hierarchy. This particular class implements the Equal function, and it can be seen that its implementation is incredibly simple due to the use
// of the interpreter pattern and the methods afforded to it by the BooleanNode superclass. It should also be noted that it only contains constants
// and no private variables, making it essentially completely closed to modification.

package model;

/**
 * Equal function.
 * @author amyzhao
 */
public class Equal extends BooleanNode {
	
	private static final String EQUAL = "Equal ";
	private static final int EXPR = 0;
	
	/**
     * Returns 1 if the all child expressions are equal; 0 otherwise.
     * @param commandDict: command dictionary for current workspace.
     * @param varDict: variable dictionary for current workspace.
     */
	@Override
	protected boolean checkCondition(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		return countNumEqual(getChildren().get(EXPR).interpret(commandDict, varDict), commandDict, varDict) == getChildren().size();
	}
	
	/**
	 * Returns the class name and its children.
	 */
	public String toString() {
		return EQUAL + childrenToString();
	}
}
