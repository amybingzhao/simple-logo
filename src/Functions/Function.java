package Functions;

import java.util.List;

import Controller.Command;
import Controller.Parser;

/**
 * Abstract base class for all functions.
 * @author amyzhao
 *
 */
public abstract class Function implements FunctionInterface {
	private Parser myParser;
	
	/**
	 * Constructs a Function object with a reference to a parser.
	 * @param parser: parser for the function to use.
	 */
	public Function(Parser parser) {
		myParser = parser;
	}
	
	/**
	 * Checks if there is an error in the function call and notifies the UI.
	 */
	protected abstract void checkForError();
	
	/**
	 * Parses a command using the Parser
	 * @param input: input command to be parsed.
	 * @return List of Command objects in the order they should be executed.
	 */
	protected List<Command> parseCommand(String input) {
		return myParser.parseCommand(input);
	}
}
