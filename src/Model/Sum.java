package Model;

import java.util.List;

public class Sum extends Node {
	private static final int NUM_CHILDREN = 2;

	public Sum() {
		setNumChildrenNeeded(NUM_CHILDREN);
	}
	
	@Override
	public int interpret() {
		List<Node> children = getChildren();
		return children.get(0).interpret() + children.get(1).interpret();
	}
	
	public String toString() {
		List<Node> children = getChildren();
		return "Sum " + Integer.toString(children.get(0).interpret()) + " + " + Integer.toString(children.get(1).interpret());
	}
}
