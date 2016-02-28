package Controller;

import Model.CommandDictionary;

public class TestMain {

    public static void main(String[] args) throws ClassNotFoundException {
        Controller c = new Controller();
        c.init(100, 100);
       /* c.processCommand("make :distance 50");
        c.processCommand("to mult [ :first :second ] [ repeat :first [ fd :second ] ]");
        c.processCommand("mult 20 30");*/
        c.processCommand("setxy 1 0 home");
    }
}
