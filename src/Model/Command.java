package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blakekaplan on 2/26/16.
 */
public class Command extends Node {

    private String myName;
    private List<String> parameters;
    private List<Node> myProcedure;

    public Command(String name) {
        myName = name;
        parameters = new ArrayList<>();
    }

    public void addParam(String var) {
        parameters.add(var);
    }

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

    public void setProcedure(List<Node> procedure){
        myProcedure = procedure;
    }

    @Override
    public String toString() {
        return myName;
    }
}
