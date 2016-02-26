package Model;

import java.util.List;

public class And extends Node {

	@Override
	public double interpret() {
		List<Node> children = getChildren();
		if (children.get(0).interpret() > 0 && children.get(1).interpret() > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public String toString() {
		List<Node> children = getChildren();
		return "And " + children.get(0).toString() + " " + children.get(1).toString();
	}
	
}
