package Controller;

public class TestMain {

    public static void main(String[] args) throws ClassNotFoundException {
        Controller c = new Controller();
        c.init(100, 100);
        //c.processCommand("ifelse equal? sum 1 2 2 [ fd 50 ] [ repeat 10 [ fd 20 fd 5 ] ]");
        c.processCommand("for [:test 0 10 1] [fd :test]");
    }
}
