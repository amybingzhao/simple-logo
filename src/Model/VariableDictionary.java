package Model;

import java.util.*;

/**
 * Created by blakekaplan on 2/25/16.
 */
public class VariableDictionary {

    private static VariableDictionary instance = null;
    private static double DEFAULT = 0;
    private Map<String, Double> myVariables;

    /**
     * Gets the instance of VariableDictionary; creates one if one does not yet exist.
     * @return the instance of VariableDictionary.
     */
    public static synchronized VariableDictionary getInstance(){
        if (instance == null){
            instance = new VariableDictionary();
        }
        return instance;
    }

    /**
     * Initializes the variable map
     */
    public VariableDictionary() {
        myVariables = new HashMap<String, Double>();
    }

    /**
     * Makes a variable key/value pair.
     * @param key: string expression for the variable name.
     * @param value: current value of the variable.
     */
    public void makeVariable(String key, double value) {
        myVariables.put(key, value);
    }

    /**
     * Gets the value associated with the variable name. If the variable does not yet exist, creates it and initializes its value to 0.
     * @param key: variable name.
     * @return variable value.
     */
    public double getNodeFor(String key) {
        if (!contains(key)) {
        	myVariables.put(key, DEFAULT);
        } //else throw new NullPointerException();
        return myVariables.get(key);
    }

    /**
     * Checks if a variable of the given name already exists.
     * @param key: variable name to check for.
     * @return true if the variable name already exists; false otherwise.
     */
    public boolean contains(String key) {
        return myVariables.containsKey(key);
    }

    /**
     * Gets the set of variable names that already exist.
     * @return set of existing variable names.
     */
    public Set<String> getKeySet(){
        return myVariables.keySet();
    }
}
