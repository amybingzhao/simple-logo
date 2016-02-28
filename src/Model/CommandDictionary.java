package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by blakekaplan on 2/26/16.
 */
public class CommandDictionary {

    private Map<String, Command> commands;
    private Map<String, Integer> numArguments;

    public CommandDictionary() {
        commands = new HashMap<>();
        numArguments = new HashMap<>();
    }

    private static CommandDictionary instance;

    public static synchronized CommandDictionary getInstance() {
        if (instance == null) {
            instance = new CommandDictionary();
        }
        return instance;
    }

    public void createCommand(String key, Command newCommand) {
        commands.put(key, newCommand);
    }

    public Command getCommandFor(String key) {
        return commands.get(key);
    }

    public boolean contains(String key) {
        return commands.containsKey(key);
    }

    public void setNumArguments(String key, int numArgs) {
        numArguments.put(key, numArgs);
    }

    public int getNumArgsForkey(String key) {
        return numArguments.get(key);
    }
}
