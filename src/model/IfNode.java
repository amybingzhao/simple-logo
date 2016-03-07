package model;

import java.util.List;

public abstract class IfNode extends Node {
	protected boolean expressionIsTrue(double val) {
		return val != 0;
	}
	
	protected double ifStatement(int numChildren, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
        if (expressionIsTrue(children.get(0).interpret(commandDict, varDict))) {
            return children.get(1).interpret(commandDict, varDict);
        }
        if (numChildren > 2) {
        	return children.get(2).interpret(commandDict, varDict);
        } else {
        	return 0;
        }
	}
	
	@Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        return ifStatement(getChildren().size(), commandDict, varDict);
    }
}
