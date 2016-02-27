package Model;

import java.util.List;

public class Forward extends Node {

    @Override
    public double interpret() {
        Turtle turtle = getTurtle();
        List<Node> children = getChildren();

        double dist = children.get(0).interpret();
        double dir = turtle.getDirection();

        if (turtle != null) {
        	for (int i = 0; i < dist; i++) {
        		turtle.move(turtle.getCurX() + Math.round(1.0 * Math.sin(Math.toRadians(dir))), 
        				turtle.getCurY() + Math.round(1.0 * Math.cos(Math.toRadians(dir))));
        	}
        }
        
        return dist;
    }

    @Override
    public String toString() {
        List<Node> children = getChildren();
        return "Forward " + children.get(0).toString();
    }
}