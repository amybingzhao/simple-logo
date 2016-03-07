package model;

import java.util.List;
import java.util.function.Predicate;

public abstract class BooleanNode extends Node {

	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		if (checkCondition(commandDict, varDict)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	protected int countNumTrue(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		Predicate<Double> trueCondition = val -> val != 0;
        return countNumMatchingCondition(trueCondition, commandDict, varDict);
	}
	
	protected int countNumEqual(double valToMatch, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		Predicate<Double> equalCondition = val -> val == valToMatch;
        return countNumMatchingCondition(equalCondition, commandDict, varDict);
	}
	
	private int countNumMatchingCondition(Predicate<Double> condition, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		List<Node> children = getChildren();
		int numMatching = 0;
        for (int i = 0; i < children.size(); i++) {
        	if (condition.test(children.get(i).interpret(commandDict, varDict))) {
        		numMatching++;
        	}
        }
		return numMatching;
	}
	 
	 protected abstract boolean checkCondition(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException;
}
