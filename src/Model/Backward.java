package Model;

import java.util.List;

public class Backward extends Node {

	private static final int DISTANCE = 0;

    @Override
    public double interpret() {
        Turtle turtle = getTurtle();
        List<Node> children = getChildren();

        double dist = children.get(DISTANCE).interpret();
        if (turtle != null) {
        	turtle.move(-dist);
        }
        
        return dist;
    }

    @Override
    public String toString() {
        List<Node> children = getChildren();
        return "Backward " + children.get(DISTANCE).toString();
    }
}