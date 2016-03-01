package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Command object
 * Created by blakekaplan on 2/26/16.
 */
public class Command extends Node {

    private String myName;
    private List<String> parameters;
    private List<Node> myProcedure;

    /**
     * Initializes the name and the parameters list for the command.
     * @param name: name of the command.
     */
    public Command(String name) {
        myName = name;
        parameters = new ArrayList<>();
    }

    /**
     * Adds a variable to the list of parameters.
     * @param var: name of variable to add.
     */
    public void addParam(String var) {
        parameters.add(var);
    }

    /**
     * Executes the command using the given parameters.
     */
    @Override
    public double interpret() {
        List<Node> children = getChildren();
        for (int i = 0; i < parameters.size(); i++) {
            String myVar = parameters.get(i);
            Constant value = (Constant) children.get(0);
            children.remove(0);
            VariableDictionary.getInstance().makeVariable(myVar, value.interpret());
        }
        for (Node myNode : myProcedure){
            myNode.interpret();
        }
        return 0;
    }

    /**
     * Sets the command procedure.
     * @param procedure: child command trees to be executed.
     */
    public void setProcedure(List<Node> procedure){
        myProcedure = procedure;
    }

    /**
	 * Returns the name of this command. 
	 */
    @Override
    public String toString() {
        return myName;
    }
}
