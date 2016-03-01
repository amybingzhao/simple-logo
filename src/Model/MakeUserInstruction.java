package Model;

import java.util.List;

/**
 * MakeUserInstruction function to implement To.
 * Created by blakekaplan on 2/25/16.
 */
public class MakeUserInstruction extends Node {

    private static final String TO = "to ";
    private static final int NAME = 0;
    private static final int VARIABLES = 1;
    private static final int COMMANDS = 2;
    private String name;

    /**
     * Creates a new user-defined command with the given name and parameters list that executes the given commands list.
     */
    //TODO: must return 0 if command not successfully defined
    public double interpret() throws ClassNotFoundException {
        List<Node> children = getChildren();
        name = children.get(NAME).toString();
        Command myCommand = new Command(name);
        CommandList paramList = (CommandList) children.get(VARIABLES);
        List<Node> parameters = paramList.getChildren();
        for (Node myNode : parameters) {
            Variable myVar = (Variable) myNode;
            myCommand.addParam(myVar.toString());
        }
        CommandDictionary.getInstance().setNumArguments(name, parameters.size());
        CommandList expressions = (CommandList) children.get(COMMANDS);
        myCommand.setProcedure(expressions.getChildren());
        CommandDictionary.getInstance().createCommand(name, myCommand);
        CommandDictionary myDict = CommandDictionary.getInstance();
        return 1;
    }

    /**
     * Gets the name of the command.
     * @return command name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the command.
     * @param newName: new name for the command.
     */
    public void setName(String newName) {
        name = newName;
    }
    
    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
    	List<Node> children = getChildren();
        return TO + children.get(NAME).toString() + " " + children.get(VARIABLES).toString() + " " + children.get(COMMANDS).toString();
    }
}
