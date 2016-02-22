package Controller;

import java.util.List;

/**
 * This class is used to parse command strings into Command objects.
 * @author amyzhao
 *
 */
public interface Parser {
	//private List<Command> myCommands;
	
	/**
	 * Parses a given string of commands into a List of commands.
	 * @param input: user input 
	 * @return List of Commands that can be executed in the order that they were inputed by the user.
	 */
	public List<Command> parseCommand(String input);
}
