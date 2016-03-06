package model;

public class Shape extends DisplayNode {

	private static final String SHAPE = "shape ";
	
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		//return getCanvas().getTurtleShapeIndex();
		return 0;
	}

	@Override
	public String toString() {
		return SHAPE;
	}
}
