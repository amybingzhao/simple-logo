package Controller;

import Model.CommandDictionary;

public class TestMain {

    public static void main(String[] args) throws ClassNotFoundException {
        Controller c = new Controller();
        c.init(100, 100);
        c.processCommand("goto 3 4 xcor ycor");
    }
}
