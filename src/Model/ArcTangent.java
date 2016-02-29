package Model;

/**
 * Created by blakekaplan on 2/27/16.
 */
public class ArcTangent extends Node {

    private static final String ARC_TANGENT = "atan ";	// is there a reason why this is public?
    private static final int DEGREES = 0;
    private static final int DEGREES_PER_PI = 180;
    
    @Override
    public double interpret() {
        double degrees = getChildren().get(DEGREES).interpret();
        double radians = degrees * (Math.PI / DEGREES_PER_PI);
        return Math.atan(radians);
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return ARC_TANGENT + getChildren().get(DEGREES).toString();
    }
}
