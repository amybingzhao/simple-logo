package Model;

import java.util.List;

public class Forward extends Node {
	
	@Override
	public int interpret() {
		Turtle turtle = getTurtle();
		List<Node> children = getChildren();
		
		int dist = children.get(0).interpret(); 
		int dir = turtle.getDirection();
		
		if (turtle != null) {
			int x = turtle.getCurX() + (int) Math.round(dist * Math.sin(Math.toRadians(dir)));
			int y = turtle.getCurY() + (int) Math.round(dist * Math.cos(Math.toRadians(dir)));
			turtle.move(x, y);
			return dist;
		}
		return 0;
	}

	@Override
	public String toString() {
		List<Node> children = getChildren();
		return "Forward " + children.get(0).toString();
	}
}