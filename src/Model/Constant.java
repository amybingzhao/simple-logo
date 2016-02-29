package Model;

public class Constant extends Node {

    private int val;

    /**
     * Sets the value of this constant.
     * @param val: value of the constant.
     */
    public Constant(int val) {
        this.val = val;
    }

    /**
     * Returns the value of this constant.
     */
    @Override
    public double interpret() {
        return val;
    }

    /**
	 * Returns the required user input for this command. 
	 */
    @Override
    public String toString() {
        return Integer.toString(val);
    }

}
