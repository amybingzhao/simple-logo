package model;

import java.util.List;

/**
 * Or function.
 * @author amyzhao
 *
 */
public class Or extends Node {

	private static final String OR = "or ";
	
	/**
	 * If expr1 or expr2 is true, returns 1; else 0.
	 * @param commandDict
	 * @param varDict
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
		for (int i = 0; i < children.size(); i++) {
        	if (children.get(i).interpret(commandDict, varDict) == 1) {
        		return 1;
        	}
        }
        return 0;
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	public String toString() {
		return OR + childrenToString();
	}
	
}
