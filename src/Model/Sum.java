package Model;

import java.util.List;

public class Sum extends Node{
	
	@Override
	public double interpret() {
		List<Node> children = getChildren();
		return children.get(0).interpret() + children.get(1).interpret();
	}
	
	public String toString() {
		List<Node> children = getChildren();
		return "Sum " + children.get(0).toString() + " " + children.get(1).toString();
	}
}
