package Controller;

import java.util.ArrayList;
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
	private static final String AVAILABLE_FUNCTIONS = "AvailableFunctions.properties";
	private ResourceBundle FunctionToNumArgsProperties = ResourceBundle.getBundle(FUNCTION_TO_NUM_ARGS_PROPERTIES);
	private ResourceBundle myAvailableFunctions = ResourceBundle.getBundle(AVAILABLE_FUNCTIONS);
	private Map<String, Integer> myNumArgsForUserDefinedCommandsMap;
	private Map<String, Integer> myUserDefinedCommandsMap;
	private List<Command> myParsedCommands;
	
	public Parser() {
		myNumArgsForUserDefinedCommandsMap = new HashMap<String, Integer>();
		myUserDefinedCommandsMap = new HashMap<String, Integer>();
		myParsedCommands = new ArrayList<Command>();
	}
	
	/**
	 * Parses a given string of commands into a List of commands.
	 * @param input: user input 
	 * @return List of Commands that can be executed in the order that they were inputed by the user.
	 */
	public List<Command> parseCommand(String input) {
		// split by white space
		
		// assume it starts with a fn name, else throw error "unknown function"
		// if to fn then call addNewUserDefinedCommand
		// should we also add a check when getting arguments for whether or not they're an arg or a fn to throw invalid # args error?
		
		// add to list of parsed commands
		
		return myParsedCommands;
	}
	
	private void addNewUserDefinedCommand() {
		// add name of new command + # args to numargs map
		
		// add string of the entire command to userdefinedcommands map
	}
	
	private void executeUserDefinedCommand() {
		//replace parameters with values before giving it back to the controller, e.g. for dash - replace all instances of
		// count and size with vals for count and size, then send that to parseCommand ^
	}
}
