package Model;

import java.util.List;

public class Not extends Node {

	@Override
	public double interpret() {
		List<Node> children = getChildren();
		if (children.get(0).interpret() == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public String toString() {
		List<Node> children = getChildren();
		return "Not " + children.get(0).toString();
	}
	
}
