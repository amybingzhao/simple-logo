package Model;

import java.util.List;

/**
 * Created by blakekaplan on 2/25/16.
 */
public class MakeUserInstruction extends Node {

    private String name;

    public static final String TO = "MakeUserInstruction";

    public double interpret() {

        List<Node> children = getChildren();
        name = children.get(0).toString();
        Command myCommand = new Command(name);
        CommandList paramList = (CommandList) children.get(1);
        List<Node> parameters = paramList.getChildren();
        for (Node myNode : parameters) {
            Variable myVar = (Variable) myNode;
            myCommand.addParam(myVar.toString());
        }
        CommandDictionary.getInstance().setNumArguments(name, parameters.size());
        CommandList expressions = (CommandList) children.get(2);
        myCommand.setProcedure(expressions.getChildren());
        CommandDictionary.getInstance().createCommand(name, myCommand);
        CommandDictionary myDict = CommandDictionary.getInstance();
        return 1;
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return TO;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }
}
