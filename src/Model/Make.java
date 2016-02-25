package Model;

import java.util.List;

/**
 * Created by blakekaplan on 2/25/16.
 */
public class Make extends Node {

    public static final String MAKE = "Make";

    private String myName;
    private String myExpression;

    public Make(String variableName, String expression){

        myName = variableName;
        myExpression = expression;
    }

    @Override
    public String toString() {
        return MAKE;
    }

    @Override
    public int interpret() {


        return 1;
    }
}
