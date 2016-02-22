package Functions;

import java.util.List;

/**
 * Interface for all functions.
 * @author amyzhao
 *
 */
public interface FunctionInterface {
	
	/**
	 * Executes the function with the given arguments.
	 * @param args: arguments for the function.
	 */
	public void execute(List<Object> args);
	
	/**
	 * Converts the function to a string.
	 */
	public abstract String toString();
}
