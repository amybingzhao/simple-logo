package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Node implements LogoFunctions {
	private List<Node> myChildren;
	private int numChildrenNeeded;
	
	public Node() {
		myChildren = new ArrayList<Node>();
	}
	
	public void addChild(Node child) {
		myChildren.add(child);
	}
	
	public int getNumChildrenNeeded() {
		return numChildrenNeeded;
	}
	
	protected void setNumChildrenNeeded(int n) {
		numChildrenNeeded = n;
	}
	
	public List<Node> getChildren() {
		return myChildren;
	}
	
	public abstract String toString();
}
