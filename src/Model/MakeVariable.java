package Model;

import java.util.List;

/**
 * Created by blakekaplan
 */

//TODO: Implement proper logic - this is the logic for To

public class MakeVariable extends Node {

    public static final String MAKE = "Make";
    private String name;

    @Override
    public String toString() {
        return MAKE;
    }

    @Override
    public double interpret() {

        List<Node> children = getChildren();
        String key = children.get(0).toString();
        double value = children.get(1).interpret();
        VariableDictionary.getInstance().makeVariable(key, value);
        return 0;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }
}
