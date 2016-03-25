// This entire file is part of my masterpiece.
// Amy Zhao

// For my code masterpiece, I chose to refactor the IFunctions interface, the Node superclass, the BooleanNode superclass, and
// the Equal subclass to demonstrate some of our back-end design choices for implementing a single SLogo function.

// The purpose of this interface is to provide a clear, concise overview of the methods that are common to all SLogo functions.
// We used the interpreter design pattern to take advantage of polymorphism, since all functions have a subset of common methods
// that are the only ones called by other classes, and it also allows for greater clarity and readability since other programmers
// know that this interface only has these 3 methods. Thus, when passing lists and trees of IFunctions in the Parser, the 
// Controller, and in the children of different IFunctions nodes, the programmer knows exactly what behavior the object has 
// available for them to use without having to understand the implementation of each SLogo function because of the abstraction 
// provided to them by the IFunctions interface.

package model;

import java.util.List;

/**
 * Function interface for logo functions.
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
