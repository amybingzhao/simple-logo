package Model;

import java.util.List;

/**
 * Object representing a list of commands.
 * @author amyzhao
 *
 */
public class CommandList extends Node {

	/**
     * Interprets a list of commands, executing each command within the list.
     */
    @Override
    public double interpret() throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<Node> children = getChildren();
        double ret = 0;

        for (int i = 0; i < children.size(); i++) {
            ret = children.get(i).interpret();
        }

        return ret;
    }

    /**
	 * Returns the required user input for this command. 
	 */
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

}
