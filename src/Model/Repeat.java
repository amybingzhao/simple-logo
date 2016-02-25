package Model;

import java.util.List;

public class Repeat extends Node {

	// child 0 is number of repeats
	// child 1 is list to repeat
	@Override
	public int interpret() {
		List<Node> children = getChildren();
		int numIter = children.get(0).interpret();
		int ret = 0;
		
		if (Controller.Controller.repCount == null) {
			Controller.Controller.repCount = 0;
		}
		
		for (int i = 0; i < numIter; i++) {
			Controller.Controller.repCount = i;
			ret = children.get(1).interpret();
		}
		
		return ret;
	}

	@Override
	public String toString() {
		List<Node> children = getChildren();
		return "Repeat " + children.get(0).toString() + " " + children.get(1).interpret();
	}

	
}
