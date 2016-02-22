package Functions;

import java.util.List;

import Controller.Parser;

/**
 * Abstract base class for evaluation functions (i.e. functions that return an int or bool).
 * @author amyzhao
 */

public abstract class EvalFunction extends Function {

	/**
	 * Constructs a EvalFunction object with a reference to a parser.
	 * @param parser: parser for the function to use.
	 */
	public EvalFunction(Parser parser) {
		super(parser);
	}
	
	/**
	 * Prints the result to the console for the user to see.
	 * @param output: output to print to the console.
	 */
	protected void printToConsole(String output) {
		
	}
}
