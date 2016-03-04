package Model;

import java.lang.reflect.InvocationTargetException;

/**
 * Interpreter interface for logo functions.
 * @author amyzhao
 *
 */
public interface IFunctions {
		double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
