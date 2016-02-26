package Model;

import java.util.List;

public class DoTimes extends Node {

	@Override
	public double interpret() {
		List<Node> children = getChildren();
		Node iterVar = children.get(0);
		String var = iterVar.getChildren().get(0).toString(); // first child in command list should be varaible;
		double limit = iterVar.getChildren().get(1).interpret(); // second child is limit
		double ret = 0;
		
		// spec said to go from 1:limit
		for (double i = 1; i < limit; i++) {
			VariableDictionary.getInstance().makeVariable(var, i);
			ret = children.get(1).interpret();
		}
		
		return ret;
	}

	@Override
	public String toString() {
		List<Node> children = getChildren();
		return "DoTimes " + children.get(0).toString() + " " + children.get(1).toString();
	}

}
