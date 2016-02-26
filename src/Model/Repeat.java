package Model;

import java.util.List;

public class Repeat extends Node {

	// child 0 is number of repeats
	// child 1 is list to repeat
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		double numIter = children.get(0).interpret();
		double ret = 0;
		
		for (int i = 0; i < numIter; i++) {
			VariableDictionary.getInstance().makeVariable("repCount", 0);
			ret = children.get(1).interpret();
		}
		
		return ret;
	}

	@Override
	public String toString() {
		List<Node> children = getChildren();
		return "Repeat " + children.get(0).toString() + " " + children.get(1).toString();
	}

	
}
