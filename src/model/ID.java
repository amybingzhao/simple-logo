package model;

import java.util.List;

public class ID extends TurtleNode {

	private static final String ID = "ID ";
	@Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		List<Turtle> curTurtles = getTurtles();
		for (int i = 0; i < curTurtles.size(); i++) {
			if (curTurtles.get(i).isCurrentTurtle()) {
				return curTurtles.get(i).getID();
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return ID;
	}

	@Override
    protected double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict)
            throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

}
