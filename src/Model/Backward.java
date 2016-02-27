package Model;

import java.util.List;

public class Backward extends Node {

    @Override
    public double interpret() {
        Turtle turtle = getTurtle();
        List<Node> children = getChildren();

        double dist = children.get(0).interpret();
        double dir = turtle.getDirection();

        if (turtle != null) {
        	for (int i = 0; i < dist; i++) {
        		turtle.move(turtle.getCurX() - Math.sin(Math.toRadians(dir)), 
        				turtle.getCurY() - Math.cos(Math.toRadians(dir)));
        	}
        }
        
        return dist;
    }

    @Override
    public String toString() {
        List<Node> children = getChildren();
        return "Backward " + children.get(0).toString();
    }
}