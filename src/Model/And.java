package Model;

import java.util.List;

public class And extends Node {
	
	private static final String AND = "and ";
	private static final int EXPR1 = 0;
	private static final int EXPR2 = 1;
	
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		if (children.get(EXPR1).interpret() > 0 && children.get(EXPR2).interpret() > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public String toString() {
		List<Node> children = getChildren();
		return AND + children.get(EXPR1).toString() + " " + children.get(EXPR2).toString();
	}
	
}
