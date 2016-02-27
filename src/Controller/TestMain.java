package Controller;

public class TestMain {

    public static void main(String[] args) throws ClassNotFoundException {
        Controller c = new Controller();
        c.init(100, 100);
//        c.processCommand("for [ :test 0 10 1 ] [ fd :test ]");
        c.processCommand("make :distance 50");
        c.processCommand("to square [ :distance ] [ repeat 4 [ fd :distance ] ]");
        c.processCommand("fd square 20");
    }
}
