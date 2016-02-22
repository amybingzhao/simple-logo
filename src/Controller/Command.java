package Controller;

import java.util.List;

import Functions.Function;

/**
 * Command objects hold both a function and an argument that the command intends to execute.
 * @author amyzhao
 *
 */
public class Command {

	private Function myFunction;
	private List<Object> myArguments;
	
	/**
	 * Executes the given function with the given arguments.
	 * @return true if successfully executed, false if it threw an error.
	 */
	public boolean execute() {
		return false;
	}
	
	/**
	 * Returns the function + argument that was passed in to create this Command object.
	 */
	public String toString() {
		return "";
	}
}
