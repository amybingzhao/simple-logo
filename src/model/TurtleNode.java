package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class TurtleNode extends Node {
    private List<Turtle> myTurtles;

    public TurtleNode() {
    	super();
        myTurtles = null;
    }
    
    public void setTurtleList(List<Turtle> curTurtles) {
    	myTurtles = curTurtles;
    }
    /**
     * Gets this node's turtle.
     * @return the turtle assigned to this node.
     */
    protected List<Turtle> getActiveTurtles() {
    	List<Turtle> curTurtles = getTurtles();
        List<Turtle> activeTurtles = new ArrayList<Turtle>();
        for (int i = 0; i < curTurtles.size(); i++) {
        	if (curTurtles.get(i).isActive()) {
        		activeTurtles.add(curTurtles.get(i));
        	}
        }
        return activeTurtles;
    }
    
    public void createTurtle(double ID) {
    	Turtle turtle = new Turtle(ID);
		turtle.setActive(true);
    	myTurtles.add(turtle);
    }
    
    public List<Turtle> getTurtles() {
    	if (myTurtles != null) {
    		if (myTurtles.isEmpty()) {
    			createTurtle(0);
    		}
    		return myTurtles;
    	}
    	return null;
    }
    
    protected double applyToActiveTurtles(List<Turtle> list, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
    	double ret = 0;
    	for (int i = 0; i < list.size(); i++) {
    		list.get(i).changeCurrentTurtleStatus(true);
    		ret = applyToIndividualTurtle(list.get(i), commandDict, varDict);
    		list.get(i).changeCurrentTurtleStatus(false);
    	}
    	return ret;
    }
    
    @Override
    public double interpret(CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException {
        return applyToActiveTurtles(getActiveTurtles(), commandDict, varDict);
    }
    
    protected abstract double applyToIndividualTurtle(Turtle turtle, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException;
    
    protected Turtle getTurtleByID(double ID) {
    	for (int i = 0; i < myTurtles.size(); i++) {
    		if (myTurtles.get(i).getID() == ID) {
    			return myTurtles.get(i);
    		}
    	}
    	return null;
    }
    
    protected void activateTurtlesInList(List<Double> turtleIDs) {
    	inactivateAllTurtles();
		for (int i = 0; i < turtleIDs.size(); i++) {
			Turtle turtle = getTurtleByID(turtleIDs.get(i));
			if (turtle != null) {
				turtle.changeCurrentTurtleStatus(true);
				turtle.setActive(true);
				turtle.changeCurrentTurtleStatus(false);
			} else {
				createTurtle(turtleIDs.get(i));
			}
		}
    }
    
    protected double applyToTurtlesInList(List<Double> turtleIDs, List<Turtle> origActiveTurtles, CommandDictionary commandDict, VariableDictionary varDict) throws ClassNotFoundException, NullPointerException, IndexOutOfBoundsException {
    	activateTurtlesInList(turtleIDs);
		double ret = getChildren().get(1).interpret(commandDict, varDict);
		activateTurtlesInList(getTurtleIDs(origActiveTurtles));
		return ret;
    }
    
    protected List<Double> getTurtleIDs(List<Turtle> turtles) {
    	List<Double> IDs = new ArrayList<>();
    	for (int i = 0; i < turtles.size(); i++) {
    		IDs.add(turtles.get(i).getID());
    	}
    	return IDs;
    }
    
    protected void activateTurtles(double maxID) {
    	List<Double> IDs = new ArrayList<>();
    	for (double i = 0; i <= maxID; i = i+1) {
    		IDs.add(i);
    	}
    	activateTurtlesInList(IDs);
    }
    
    protected void inactivateAllTurtles() {
    	for (int i = 0; i < myTurtles.size(); i++) {
			Turtle turtle = myTurtles.get(i);
			turtle.setActive(false);
		}
    }
    
    protected double checkTurtleProperty(Predicate<Turtle> pred, Turtle turtle) {
    	if (pred.test(turtle)) {
    		return 1;
    	} else {
    		return 0;
    	}
    }
}
