package Model;

import java.util.List;

public class Equal extends Node {
	
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		if (children.get(0).interpret() == children.get(1).interpret()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public String toString() {
		List<Node> children = getChildren();
		return "Equal? " + children.get(0).toString() + " " + children.get(1).toString();
	}
}
