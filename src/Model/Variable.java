package Model;

public class Variable extends Node {

    private String name;
    private String expression;

    public Variable(String name) {
        this.name = name;
    }

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
