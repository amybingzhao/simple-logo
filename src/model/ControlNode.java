package model;

public abstract class ControlNode extends Node {
	protected boolean expressionIsTrue(double val) {
		return val != 0;
	}
}
