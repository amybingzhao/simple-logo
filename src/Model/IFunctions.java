package Model;

/**
 * Interpreter interface for logo functions.
 * @author amyzhao
 *
 */
public interface IFunctions {
		double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException;
}
