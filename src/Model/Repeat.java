package Model;

import java.util.List;

public class Repeat extends Node {

	private static final String REPEAT = "repeat ";
	private static final int EXPR = 0;
	private static final int COMMANDS = 1;
	private static final String REPCOUNT_VARIABLE = "repCount";
	
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		double numIter = children.get(EXPR).interpret();
		double ret = 0;
		
		for (int i = 0; i < numIter; i++) {
			VariableDictionary.getInstance().makeVariable(REPCOUNT_VARIABLE, i);
			ret = children.get(COMMANDS).interpret();
		}
		
		return ret;
	}

	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		List<Node> children = getChildren();
		return REPEAT + children.get(EXPR).toString() + " " + children.get(COMMANDS).toString();
	}

	
}
