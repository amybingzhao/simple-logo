package Model;

import java.util.List;

/**
 * Created by blakekaplan on 2/25/16.
 */
public class For extends Node{

    private static final String FOR = "For";
    private static final int VARIABLE_AND_LIMITS = 0;
    private static final int COMMANDS = 1;

    public String toString() {
        return FOR;
    }

    @Override
    public double interpret() {

        List<Node> children = getChildren();
        CommandList argList = (CommandList) children.get(VARIABLE_AND_LIMITS);
        List<Node> argsNodes = argList.getChildren();
        double low = argsNodes.get(1).interpret();
        double high = argsNodes.get(2).interpret();
        double increment = argsNodes.get(3).interpret();
        Variable myVar = (Variable) argsNodes.get(0);
        String varString = myVar.toString();

        double ret = 0;

        for (double i = low; i < high; i += increment){
            VariableDictionary.getInstance().makeVariable(varString, i);
            ret = children.get(COMMANDS).interpret();
        }

        return ret;
    }
}
