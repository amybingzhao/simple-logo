package Model;

import java.util.List;

public class Equal extends Node {
	
	private static final String EQUAL = "equal? ";
	private static final int EXPR1 = 0;
	private static final int EXPR2 = 0;
	
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		if (children.get(EXPR1).interpret() == children.get(EXPR2).interpret()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public String toString() {
		List<Node> children = getChildren();
		return EQUAL + children.get(EXPR1).toString() + " " + children.get(EXPR2).toString();
	}
}
