package model;

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
    private List<String> myCommandList;

    public MakeUserInstruction(List<String> inputCommandList) {
        myCommandList = inputCommandList;
        myName = myCommandList.get(0);
    }

    /**
     * Creates a new user-defined command with the given name and parameters list that executes the given commands list.
     *
     * @param commandDict
     * @param varDict
     */
    //TODO: must return 0 if command not successfully defined
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<IFunctions> children = getChildren();
        Command myCommand = new Command(myName);
        CommandList paramList = (CommandList) children.get(VARIABLES);
        List<IFunctions> parameters = paramList.getChildren();
        for (IFunctions myNode : parameters) {
            Variable myVar = (Variable) myNode;
            myCommand.addParam(myVar.toString());
        }
        CommandList expressions = (CommandList) children.get(PROCEDURE);
        myCommand.setProcedure(expressions.getChildren());
        commandDict.createCommand(myName, myCommand);
        commandDict.setNumArguments(myName, parameters.size());
        commandDict.storeCommandText(myName, join());
        return 1;
    }

    private String join(){
        String myCommand = "to ";
        for (String myString : myCommandList){
            myCommand = myCommand + myString + " ";
        }
        return myCommand.trim();
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
        return TO + myName + " " + childrenToString();
    }
}
