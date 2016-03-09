package model;

import java.util.List;
import java.util.ResourceBundle;

/**
 * MakeUserInstruction function to implement To.
 * Created by blakekaplan on 2/25/16.
 */
public class MakeUserInstruction extends Node {

    private static final String TO = "to ";
    private static final int VARIABLES = 0;
    private static final int PROCEDURE = 1;
    public static final String MAKE_USER_INSTRUCTION = "MakeUserInstruction";
    private String myName;
    private String myCurrentLanguage;

    public MakeUserInstruction(String name, String language) {
        myName = name;
        myCurrentLanguage = language;
    }

    /**
     * Creates a new user-defined command with the given name and parameters list that executes the given commands list.
     *
     * @param commandDict
     * @param varDict
     */
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
        commandDict.storeCommandText(myName, toString());
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

    private String translateToLanguage(String command){
        String translated = "";
        String[] splitCommand = command.split(" ");
        for (String entry : splitCommand){
            translated = translated + getTranslation(entry) + " ";
        }
        return translated;
    }

    private String getTranslation(String entry){
        ResourceBundle languageBundle = ResourceBundle.getBundle(myCurrentLanguage);
        if (languageBundle.containsKey(entry)){
            String options = languageBundle.getString(entry);
            String[] splitOptions = options.split("\\|");
            return splitOptions[0];
        }
        else{
            return entry;
        }
    }

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        return translateToLanguage(MAKE_USER_INSTRUCTION + " " + myName + " " + childrenToString());
    }
}
