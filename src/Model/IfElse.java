package Model;

import java.util.List;

public class IfElse extends Node {

	@Override
	public double interpret() {
		List<Node> children = getChildren();
		double ret = 0;
		
		if (children.get(0).interpret() == 1) {
			ret = children.get(1).interpret();
		} else {
			ret = children.get(2).interpret();
		}
		
		return ret;
	}

	@Override
	public String toString() {
		List<Node> children = getChildren();
		return "ifelse " + children.get(0).toString() + " " + children.get(1).toString() + " " + children.get(2).toString();
	}

}
