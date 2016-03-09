package model;

import java.util.List;

/**
 * Interpreter interface for logo functions.
 * @author amyzhao
 *
 */
public interface IFunctions {
		double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException;
		
		List<IFunctions> getChildren();
		
		String toString();
}
