package Model;

import java.util.List;

/**
 * Forward function.
 *
 * @author amyzhao
 */
public class Forward extends Node {

    private static final String FORWARD = "forward ";
    private static final int DISTANCE = 0;

    /**
     * Moves the turtle forward the given distance.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        Turtle turtle = getTurtle();
        List<Node> children = getChildren();

        double dist = children.get(DISTANCE).interpret(commandDict, varDict);
        if (turtle != null) {
            turtle.move(dist);
        }

        return dist;
    }

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        List<Node> children = getChildren();
        return FORWARD + children.get(DISTANCE).toString();
    }
}