package Functions;

import Controller.Parser;

/**
 * Abstract base class for control functions (e.g. for, if).
 * @author amyzhao
 *
 */
public abstract class ControlFunction extends Function {

	/**
	 * Constructs a ControlFunction object with a reference to a parser.
	 * @param parser: parser for the function to use.
	 */
	public ControlFunction(Parser parser) {
		super(parser);
	}

}
