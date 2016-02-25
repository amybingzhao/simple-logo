package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by blakekaplan on 2/25/16.
 */
public class VariableDictionary {

    private Map<String, Node> variables;

    public VariableDictionary(){
        variables = new HashMap<String, Node>();
    }

    public void makeVariable(String key, Node expression){
        variables.put(key, expression);
    }

    public Node getNodeFor(String key){
        if (contains(key)){
            return variables.get(key);
        }
       else throw new NullPointerException();
    }

    public boolean contains(String key){

        if (variables.containsKey(key)) return true;
        return false;

    }
}
