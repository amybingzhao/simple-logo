package Model;

import java.util.*;

/**
 * Created by blakekaplan on 2/25/16.
 */
public class VariableDictionary {

    private static VariableDictionary instance = null;

    public static VariableDictionary getInstance(){
        if (instance == null){
            instance = new VariableDictionary();
        }
        return instance;
    }

    private Map<String, Double> variables;

    public VariableDictionary() {
        variables = new HashMap<String, Double>();
    }

    public void makeVariable(String key, double value) {
        variables.put(key, value);
    }

    public double getNodeFor(String key) {
        if (contains(key)) {
            return variables.get(key);
        } else throw new NullPointerException();
    }

    public boolean contains(String key) {

        if (variables.containsKey(key)) return true;
        return false;

    }

    public Set<String> getKeySet(){
        return variables.keySet();
    }
}