// This entire file is part of my masterpiece.
// Blake Kaplan

/**
 * I chose to include this class because because it shows how extensible our design is.
 *
 * When interpret is called, the code adds the new procedure and its related information
 * to the CommandDictionary whose reference is passed into the interpret command.
 *
 * In addition, I also made the toString method adapt to all languages. The translateToLanguage
 * and getTranslation methods allow the toString method to convert an expression tree into a
 * translated string version that can be stored and later parsed to regenerate the same exact expression tree.
 * This model works for all of the languages provided in the resource files and was
 * very helpful for saving and loading the workspace's user defined commands.
 */

package model;

import java.util.List;
import java.util.ResourceBundle;

/**
 * MakeUserInstruction function to implement To.
 * Created by blakekaplan on 2/25/16.
 */
public class MakeUserInstruction extends Node {

    private static final int VARIABLES = 0;
    private static final int PROCEDURE = 1;
    public static final String MAKE_USER_INSTRUCTION = "MakeUserInstruction";
    private static final String SPACE = " ";
    private static final String SLASHES = "\\";
    private static final String OPTION_SEPARATOR = "\\|";
    private static final String EMPTY_STRING = "";
    private static final int FIRST_CHOICE = 0;
    private String myName;
    private String myCurrentLanguage;

    /**
     * Creates a MakeUserInstruction object for a command of the given name and in the user-selected language.
     * @param name: name of command.
     * @param language: user-selected language.
     */
    public MakeUserInstruction(String name, String language) {
        myName = name;
        myCurrentLanguage = language;
    }

    /**
     * Creates a new user-defined command with the given name and parameters list that executes the given commands list.
     *  @param commandDict
     * @param varDict*/
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
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

    /**
     * Translates a string into the user-defined language.
     * @param command: command to translate.
     * @return translated string.
     */
    private String translateToLanguage(String command){
        String translated = EMPTY_STRING;
        String[] splitCommand = command.split(SPACE);
        for (String entry : splitCommand){
            translated = translated + getTranslation(entry) + SPACE;
        }
        return translated;
    }

    /**
     * Gets the translation of a word from the language-specific resource file.
     * @param entry: word to translate.
     * @return translation of entry.
     */
    private String getTranslation(String entry){
        ResourceBundle languageBundle = ResourceBundle.getBundle(myCurrentLanguage);
        if (languageBundle.containsKey(entry)){
            return languageBundle.getString(entry).split(OPTION_SEPARATOR)[FIRST_CHOICE].replace(SLASHES, EMPTY_STRING);
        }
        else{
            return entry;
        }
    }

    /**
     * Returns the string representation of the procedure tree
     */
    @Override
    public String toString() {
        return translateToLanguage(MAKE_USER_INSTRUCTION + SPACE + myName + SPACE + childrenToString());
    }
}
