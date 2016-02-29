package Model;

import java.util.List;

public class IfElse extends Node {

	private static final String IFELSE = "ifelse ";
	private static final int EXPR = 0;
	private static final int TRUE_COMMANDS = 1;
	private static final int FALSE_COMMANDS = 2;
	
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		double ret = 0;
		
		if (children.get(EXPR).interpret() == 1) {
			ret = children.get(TRUE_COMMANDS).interpret();
		} else {
			ret = children.get(FALSE_COMMANDS).interpret();
		}
		
		return ret;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		List<Node> children = getChildren();
		return IFELSE + children.get(EXPR).toString() + " " + children.get(TRUE_COMMANDS).toString() + " " + children.get(FALSE_COMMANDS).toString();
	}

}
