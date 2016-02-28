package Model;

import java.util.List;

public class Sum extends Node{
	
	private static final String SUM = "sum ";
	private static final int EXPR1 = 0;
	private static final int EXPR2 = 1;
	
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		return children.get(EXPR1).interpret() + children.get(EXPR2).interpret();
	}
	
	public String toString() {
		List<Node> children = getChildren();
		return SUM + children.get(EXPR1).toString() + " " + children.get(EXPR2).toString();
	}
}
