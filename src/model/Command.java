package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Command object
 * Created by blakekaplan on 2/26/16.
 */
public class Command extends Node {

    private String myName;
    private List<String> parameters;
    private List<IFunctions> myProcedure;

    /**
     * Initializes the name and the parameters list for the command.
     *
     * @param name: name of the command.
     */
    public Command(String name) {
        myName = name;
        parameters = new ArrayList<>();
    }

    /**
     * Adds a variable to the list of parameters.
     *
     * @param var: name of variable to add.
     */
    public void addParam(String var) {
        parameters.add(var);
    }

    public List<String> getParams() {
        return parameters;
    }

    /**
     * Executes the command using the given parameters.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {

        if (!commandDict.contains(myName)) {
        	throw new ClassNotFoundException();
        } else {
        	parameters = commandDict.getCommandFor(myName).getParams();
        	myProcedure = commandDict.getCommandFor(myName).getProcedure();

        	List<IFunctions> children = getChildren();
        	for (int i = 0; i < parameters.size(); i++) {
        		String myVar = parameters.get(i);
        		double value = children.get(i).interpret(commandDict, varDict);
        		varDict.makeVariable(myVar, value);
        	}
        	for (IFunctions myNode : myProcedure) {
        		myNode.interpret(commandDict, varDict);
        	}
        	return 0;
        }
    }

    /**
     * Sets the command procedure.
     *
     * @param procedure: child command trees to be executed.
     */
    public void setProcedure(List<IFunctions> list) {
        myProcedure = list;
    }

    public List<IFunctions> getProcedure() {
        return myProcedure;
    }

    /**
     * Returns the name of this command.
     */
    @Override
    public String toString() {
        return myName;
    }
}
