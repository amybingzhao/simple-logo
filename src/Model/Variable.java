package Model;

public class Variable extends Node {

    private String name;
    private String expression;

    /**
     * Sets the name of the variable of interest.
     * @param name: name of the variable the user wants to get.
     */
    public Variable(String name) {
        this.name = name;
    }

    /**
     * Returns the value for the given variable.
     */
    @Override
    public double interpret() {
        return VariableDictionary.getInstance().getNodeFor(name);
    }

    /**
	 * Returns the string representing this variable. 
	 */
    @Override
    public String toString() {
        return name;
    }

}
