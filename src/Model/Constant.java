package Model;

public class Constant extends Node {

    private int n;

    public Constant(int n) {
        this.n = n;
    }

    @Override
    public int interpret() {
        return n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }

}
