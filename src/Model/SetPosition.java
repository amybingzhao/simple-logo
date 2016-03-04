package Model;

import java.util.List;

/**
 * SetPosition function.
 *
 * @author amyzhao
 */
public class SetPosition extends Node {

    private static final String SETXY = "setxy ";
    private static final int X = 0;
    private static final int Y = 1;

    /**
     * Moves the turtle to the given position and returns the distance moved.
     *
     * @param commandDict
     * @param varDict
     */
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
        List<Node> children = getChildren();
        Turtle turtle = getTurtle();
        double dist = turtle.calcDistance(children.get(X).interpret(commandDict, varDict), children.get(Y).interpret(commandDict, varDict));
        turtle.turnTowards(children.get(X).interpret(commandDict, varDict), children.get(Y).interpret(commandDict, varDict));
        turtle.move(dist);
        return dist;
    }

    /**
     * Returns the required user input for this command.
     */
    @Override
    public String toString() {
        List<Node> children = getChildren();
        return SETXY + children.get(X).toString() + " " + children.get(Y).toString();
    }

}
