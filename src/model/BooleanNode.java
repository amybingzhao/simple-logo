// This entire file is part of my masterpiece.
// Amy Zhao

// The purpose of this class is to provide an intermediate level of inheritance between Nodes and subclasses that evaluate boolean conditions.
// It reduces the bulkiness of both its subclasses and the Node superclass, as it reduces duplicate code in its subclasses while also isolating
// methods that are only useful for a subset of Node subclasses. By utilizing lambda expressions in countNumTrue() and countNumEqual(),
// it reduces duplicate code in the And, Or, Equal, and NotEqual subclasses, and also takes advantage of the fact that all of the boolean 
// functions return 1 for true and 0 for false to reduce duplicate code in the Not, LessThan, and GreaterThan subclasses as well. Similar intermediate
// superclasses are also implemented for Turtle functions (TurtleNode) and Display functions (DisplayNode), as these also had a great degree of
// similarity in the requirements of their subclasses. The methods in this class are also short and well-documented, with no instance variables required,
// making it closed to modification in that there are no getters and setters and thus no vulnerable data, but it is open to modification as it can be
// used to implement any SLogo function that evaluates a condition to true or false simply by adding a subclass to this superclass.


package model;

import java.util.List;
import java.util.function.Predicate;

public abstract class BooleanNode extends TreeNode {

	/**
	 * Returns 1 if given condition is satisfied; 0 o.w.
	 */
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
		if (checkCondition(commandDict, varDict)) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Abstract method for all boolean nodes that checks whether or not a condition specific to that function is satisfied.
	 */
	protected abstract boolean checkCondition(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException;
	
	/**
	 * Counts the number of children nodes that evaluate to a non-zero number.
	 * @param commandDict: command dictionary for current workspace.
	 * @param varDict: variable dictionary for current workspace.
	 * @return: number of child nodes that evaluate to true.
	 * @throws ClassNotFoundException
	 */
	protected int countNumTrue(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
		Predicate<Double> trueCondition = val -> val != 0;
		return countNumMatchingCondition(trueCondition, commandDict, varDict);
	}

	/**
	 * Counts the number of children nodes that equal a given number.
	 * @param valToMatch: value that the children must equal to be counted.
	 * @param commandDict: command dictionary for current workspace.
	 * @param varDict: variable dictionary for current workspace.
	 * @return: number of child nodes that equal the given value.
	 * @throws ClassNotFoundException
	 */
	protected int countNumEqual(double valToMatch, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
		Predicate<Double> equalCondition = val -> val == valToMatch;
		return countNumMatchingCondition(equalCondition, commandDict, varDict);
	}

	/**
	 * Counts the number of children that satisfy a given predicate.
	 * @param condition: condition to satisfy.
	 * @param commandDict: command dictionary for current workspace.
	 * @param varDict: variable dictionary for current workspace.
	 * @return the number of children that satisfy the given predicate.
	 * @throws ClassNotFoundException
	 */
	private int countNumMatchingCondition(Predicate<Double> condition, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
		List<IFunctions> children = getChildren();
		int numMatching = 0;
		for (int i = 0; i < children.size(); i++) {
			if (condition.test(children.get(i).interpret(commandDict, varDict))) {
				numMatching++;
			}
		}
		return numMatching;
	}
}
