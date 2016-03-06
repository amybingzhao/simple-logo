package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by blakekaplan on 2/26/16.
 */
public class CommandDictionary {

    private Map<String, Command> myCommands;
    private Map<String, Integer> myNumArguments;

    public CommandDictionary(){
        myCommands = new HashMap<>();
        myNumArguments = new HashMap<>();
    }

    /**
     * Creates a new command with the given command name.
     *
     * @param key:        command name.
     * @param newCommand: command object representing the command.
     */
    public void createCommand(String key, Command newCommand) {
        if (!myCommands.containsKey(key)) {
            myCommands.put(key, newCommand);
        } else {
            myCommands.remove(key);
            myCommands.put(key, newCommand);
        }
    }

    /**
     * Gets the command associated with a given command name.
     *
     * @param key: command name.
     * @return command object for the given command name.
     */
    public Command getCommandFor(String key) {
        Command commandToGet = myCommands.get(key);
        Command ret = new Command(key);
        for (int i = 0; i < commandToGet.getParams().size(); i++) {
            ret.addParam(commandToGet.getParams().get(i));
        }
        ret.setProcedure(commandToGet.getProcedure());
        return ret;
    }

    /**
     * Checks if a command of the given name already exists.
     *
     * @param key: command name to check.
     * @return true if command name already exists; false otherwise.
     */
    public boolean contains(String key) {
        return myCommands.containsKey(key);
    }

    /**
     * Sets the number of arguments required for a given command.
     *
     * @param key:     command name.
     * @param numArgs: number of arguments required.
     */
    public void setNumArguments(String key, int numArgs) {
        myNumArguments.put(key, numArgs);
    }

    /**
     * Gets the number of arguments required for a given command.
     *
     * @param key: command name.
     * @return number of arguments required.
     */
    public int getNumArgsForkey(String key) {
        return myNumArguments.get(key);
    }

    /**
     * Gets the set of command names already defined.
     *
     * @return existing set of command names.
     */
    public Set<String> getCommandKeySet() {
        return myCommands.keySet();
    }
}
