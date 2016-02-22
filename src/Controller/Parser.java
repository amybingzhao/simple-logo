package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * This class is used to parse command strings into Command objects.
 * @author amyzhao
 *
 */
public class Parser {
	private static final String FUNCTION_TO_NUM_ARGS_PROPERTIES = "NumArgsForFunctions.properties";
	private ResourceBundle FunctionToNumArgsProperties = ResourceBundle.getBundle(FUNCTION_TO_NUM_ARGS_PROPERTIES);
	private static final String AVAILABLE_FUNCTIONS = "AvailableFunctions.properties";
	private ResourceBundle myAvailableFunctions = ResourceBundle.getBundle(AVAILABLE_FUNCTIONS);
	private List<Command> myCommands;
	private Map<String, Integer> myNumArgsForUserDefinedCommandsMap;
	private Map<String, Integer> myUserDefinedCommandsMap;
	
	/**
	 * Parses a given string of commands into a List of commands.
	 * @param input: user input 
	 * @return List of Commands that can be executed in the order that they were inputed by the user.
	 */
	public List<Command> parseCommand(String input) {
		return myCommands;
	}
}
