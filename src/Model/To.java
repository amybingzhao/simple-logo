package Model;

import java.util.List;

/**
 * Created by blakekaplan on 2/25/16.
 */
public class To extends Node {

    private String name;

    public static final String TO = "To";

    public double interpret() {
        //TODO: Interpret To Commands

        /**
         * Copy of original Make logic - Must be changed
         */
        List<Node> children = getChildren();
        CommandList parameters = (CommandList) children.get(0);
        CommandList expressions = (CommandList) children.get(1);
        //VariableDictionary.makeVariable(name, expression);
        return 1;
    }

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
