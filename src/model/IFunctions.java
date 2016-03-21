// This entire file is part of my masterpiece.
// Amy Zhao

package model;

import java.util.List;

/**
 * Interpreter interface for logo functions.
 * @author amyzhao
 *
 */
public interface IFunctions {
	/**
	 * Interprets and executes the function.
	 * @param commandDict: command dictionary for current workspace.
	 * @param varDict: variable dictionary for current workspace.
	 * @return value that the function evaluates to.
	 * @throws ClassNotFoundException
	 */
	double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException;

	/**
	 * Gets the children of the function.
	 * @return list of children.
	 */
	List<IFunctions> getChildren();

	/**
	 * Returns a string representation of the function.
	 * @return string representation of the function.
	 */
	String toString();
}
