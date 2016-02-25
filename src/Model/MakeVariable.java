package Model;

import java.util.List;

/**
 * Created by blakekaplan
 */
public class MakeVariable extends Node {

    public static final String MAKE = "Make";
    private String name;

    @Override
    public String toString() {
        return MAKE;
    }

    @Override
    public int interpret() {

        List<Node> children = getChildren();
        Node expression = children.get(0);
        VariableDictionary.makeVariable(name, expression);
        return 1;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }
}
