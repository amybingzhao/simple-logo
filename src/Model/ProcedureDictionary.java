package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by blakekaplan on 2/26/16.
 */
public class ProcedureDictionary {

    private static ProcedureDictionary instance = null;
    private static double DEFAULT = 0;
    private Map<String, List<Node>> functions;

    public ProcedureDictionary() {
        functions = new HashMap<>();
    }

    public static synchronized ProcedureDictionary getInstance() {
        if (instance == null) {
            instance = new ProcedureDictionary();
        }
        return instance;
    }

    public void addNewFunction(String key, List<Node> procedure) {
        functions.put(key, procedure);
    }

    public List<Node> getProcedureFor(String key){
        return functions.get(key);
    }

}
