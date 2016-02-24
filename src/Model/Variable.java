package Model;

public class Variable extends Node {
	private String name;
	private int val;
	
	public Variable(String name, int val) {
		this.name = name;
		this.val = val;
	}
	
	@Override
	public int interpret() {
		return val;
	}

	@Override
	public String toString() {
		return ":" + name;
	}
}
