package Model;

import java.util.List;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class Power extends Node {

	private static final String POWER = "pow ";
	private static final int BASE = 0;
	private static final int EXPONENT = 1;
	
    @Override
    public double interpret() {
        List<Node> children = getChildren();
        return Math.pow(children.get(BASE).interpret(), children.get(EXPONENT).interpret());
    }

    @Override
    public String toString() {
        return POWER + getChildren().get(BASE).toString() + " " +getChildren().get(EXPONENT).toString();
    }
}
