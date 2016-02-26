package Model;

import java.util.List;

public class CommandList extends Node {

    @Override
    public double interpret() {
        List<Node> children = getChildren();
        double ret = 0;

        for (int i = 0; i < children.size(); i++) {
            ret = children.get(i).interpret();
        }

        return ret;
    }

    @Override
    public String toString() {
        List<Node> children = getChildren();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < children.size(); i++) {
            sb.append(children.get(i).toString());
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    public List<Node> getEntries() {
        return getChildren();
    }

}
