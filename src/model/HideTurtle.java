package model;

/**
 * HideTurtle function.
 * @author amyzhao
 *
 */
public class HideTurtle extends TurtleNode {

	private static final String HIDETURTLE = "HideTurtle ";

	/**
     * Sets the turtle to invisible.
     * @param commandDict
     * @param varDict
     */
	@Override
	protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		turtle.setVisible(false);
		return 0;
	}
	
	/**
	 * Returns the required user input for this command. 
	 */
	@Override
	public String toString() {
		return HIDETURTLE;
	}


}
