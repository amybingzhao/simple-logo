package Model;

import java.util.List;

public class GreaterThan extends Node {

	private static final String GREATER = "greater? ";
	private static final int EXPR1 = 0;
	private static final int EXPR2 = 1;
	
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		if (children.get(EXPR1).interpret() > children.get(EXPR2).interpret()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public String toString() {
		List<Node> children = getChildren();
		return GREATER + children.get(EXPR1).toString() + " " + children.get(EXPR2).toString();
	}
	
}
