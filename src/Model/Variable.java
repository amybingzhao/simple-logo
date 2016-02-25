package Model;

public class Variable extends Node {

    private String name;
    private String expression;

    public Variable(String name, String expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public int interpret() {

        return 1;

    }

    @Override
    public String toString() {
        return ":" + name;
    }

    /**
     * Provides the expression associated with the variable name
     * @return
     * The variable expression
     */
    public String getExpression(){
        return expression;
    }
}
