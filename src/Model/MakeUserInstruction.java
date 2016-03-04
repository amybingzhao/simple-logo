package Model;

import java.util.List;

/**
 * MakeUserInstruction function to implement To.
 * Created by blakekaplan on 2/25/16.
 */
public class MakeUserInstruction extends Node {

    private static final String TO = "to ";
    private static final int VARIABLES = 0;
    private static final int PROCEDURE = 1;
    private String myName;

    public MakeUserInstruction(String name) {
        myName = name;
    }

    /**
     * Creates a new user-defined command with the given name and parameters list that executes the given commands list.
     *
     * @param commandDict
     * @param varDict
     */
    //TODO: must return 0 if command not successfully defined
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<Node> children = getChildren();
        Command myCommand = new Command(myName);
        CommandList paramList = (CommandList) children.get(VARIABLES);
        List<Node> parameters = paramList.getChildren();
        for (Node myNode : parameters) {
            Variable myVar = (Variable) myNode;
            myCommand.addParam(myVar.toString());
        }
        CommandList expressions = (CommandList) children.get(PROCEDURE);
        myCommand.setProcedure(expressions.getChildren());
        commandDict.createCommand(myName, myCommand);
        commandDict.setNumArguments(myName, parameters.size());
        return 1;
    }

    /**
     * Gets the name of the command.
     *
     * @return command name.
     */
    public String getName() {
        return myName;
    }

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        //List<Node> children = getChildren();
        //return TO + myName + " " + children.get(VARIABLES).toString() + " " + children.get(PROCEDURE).toString();
        return TO + myName;
    }
}
