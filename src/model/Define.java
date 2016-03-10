package model;

import java.util.List;

/**
 * Created by blakekaplan on 3/10/16.
 */
public class Define extends Node {

    public static final String DEFINE = "Define ";

    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
        List<IFunctions> children = getChildren();
        Command myCommand = (Command) children.get(0);
        commandDict.setNumArguments(myCommand.toString(), (int) children.get(1).interpret(commandDict, varDict));
        return 1;
    }

    @Override
    public String toString() {
        return DEFINE + childrenToString();
    }
}
