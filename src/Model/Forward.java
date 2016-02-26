package Model;

import java.util.List;

public class Forward extends Node {

    @Override
    public double interpret() {
        Turtle turtle = getTurtle();
        List<Node> children = getChildren();

        double dist = children.get(0).interpret();
        int dir = turtle.getDirection();

        if (turtle != null) {
            int x = turtle.getCurX() + (int) Math.round(dist * Math.sin(Math.toRadians(dir)));
            int y = turtle.getCurY() + (int) Math.round(dist * Math.cos(Math.toRadians(dir)));
            turtle.move(x, y);
        }
        
        return dist;
    }

    @Override
    public String toString() {
        List<Node> children = getChildren();
        return "Forward " + children.get(0).toString();
    }
}