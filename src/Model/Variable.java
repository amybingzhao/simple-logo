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

    @Override
    public String toString() {
        return name;
    }

}
