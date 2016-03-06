package model;

public class PenColor extends DisplayNode {

	private static final String PEN_COLOR = "pencolor ";
	
	@Override
	public double interpret(CommandDictionary commandDict, VariableDictionary varDict)
			throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
		//return getCanvas().getPenColorIndex();
		return 0;
	}

	@Override
	public String toString() {
		return PEN_COLOR;
	}
}
