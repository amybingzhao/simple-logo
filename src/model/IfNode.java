package model;

import java.util.List;

public abstract class IfNode extends Node {
	private static final int EXPR = 0;
	private static final int TRUE_COMMANDS = 1;
	private static final int FALSE_COMMANDS = 2;
	
	protected boolean expressionIsTrue(double val) {
		return val != 0;
	}
	
	protected double ifStatement(int numChildren, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<IFunctions> children = getChildren();
        if (expressionIsTrue(children.get(EXPR).interpret(commandDict, varDict))) {
            return children.get(TRUE_COMMANDS).interpret(commandDict, varDict);
        }
        if (numChildren > 2) {
        	return children.get(FALSE_COMMANDS).interpret(commandDict, varDict);
        } else {
        	return 0;
        }
	}
	
	@Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        return ifStatement(getChildren().size(), commandDict, varDict);
    }
}
