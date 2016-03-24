// This entire file is part of my masterpiece.
// Blake Kaplan

/**
 * I chose to include this class in my masterpiece because it shows how adaptable our design was.
 * This class showcases both the extensibility of our class hierarchy and how well our design
 * incorporated variable scope.
 *
 * When interpret is called, the code retrieves the procedure and parameters from the
 * CommandDictionary and executes it accordingly. The Command class is able to serve as a placeholder
 * for user defined commands while the expression tree is being built. It then takes on the user defined
 * command's procedure during execution. This class is, therefore, well suited for our design.
 *
 * During execution in the interpret method, we also see that the code goes through a series of
 * variable creation calls to initialize the arguments. In order to keep these new variables in
 * a more local scope, we can see that a clone of the VariableDictionary is passed so that these
 * new variables remain local to the function, the only place were the VariableDictionary clone exists.
 * It is this cloned VariableDictionary that is passed into the children Nodes during execution.
 */

package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Command object
 * Created by blakekaplan on 2/26/16.
 */
public class Command extends Node {

	private String myName;
	private List<String> parameters;
	private List<IFunctions> myProcedure;

	/**
	 * Initializes the name and the parameters list for the command.
	 *
	 * @param name: name of the command.
	 */
	public Command(String name) {
		myName = name;
		parameters = new ArrayList<>();
	}

	/**
	 * Adds a variable to the list of parameters.
	 *
	 * @param var: name of variable to add.
	 */
	public void addParam(String var) {
		parameters.add(var);
	}

	public List<String> getParams() {
		return parameters;
	}

	/**
	 * Executes the command using the given parameters.
	 *  @param commandDict
	 * @param varDict*/
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {

		if (!commandDict.contains(myName)) {
			throw new ClassNotFoundException();
		} else {
			if (myProcedure == null){
				myProcedure = commandDict.getCommandFor(myName).getProcedure();
			} 
			VariableDictionary scopedDictionary = varDict.createClone();
            Command myCommand = commandDict.getCommandFor(myName);
			parameters = myCommand.getParams();
			myProcedure = myCommand.getProcedure();

			List<IFunctions> children = getChildren();
			for (int i = 0; i < parameters.size(); i++) {
				String myVar = parameters.get(i);
				double value = children.get(i).interpret(commandDict, varDict);
				scopedDictionary.makeVariable(myVar, value);
			}
			for (IFunctions myNode : myProcedure) {
				myNode.interpret(commandDict, scopedDictionary);
			}
		}
		return 1;
	}

	/**
	 * Sets the command procedure.
	 *
	 * @param list: child command trees to be executed.
	 */
	public void setProcedure(List<IFunctions> list) {
		myProcedure = list;
	}

	/**
	 * Gets the procedure for the given command.
	 * @return list of nodes specifying the user-defined procedure.
	 */
	public List<IFunctions> getProcedure() {
		return myProcedure;
	}

	/**
	 * Returns the name of this command.
	 */
	@Override
	public String toString() {
		return myName;
	}
}
