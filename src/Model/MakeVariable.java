package Model;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * MakeVariable function to implement Make.
 * Created by blakekaplan
 */

public class MakeVariable extends Node {

    private static final String MAKE = "make ";
    private static final int VARIABLE_NAME = 0;
    private static final int EXPRESSION = 1;
    private String name;

    @Override
    public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Node> children = getChildren();
        String key = children.get(VARIABLE_NAME).toString();
        double value = children.get(EXPRESSION).interpret();
        VariableDictionary.getInstance().makeVariable(key, value);
        return value;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }
    
    @Override
    public String toString() {
        List<Node> children = getChildren();
        return MAKE + children.get(VARIABLE_NAME).toString() + " " + children.get(EXPRESSION).toString();
    }
}
