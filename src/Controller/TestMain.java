package Controller;

import Model.Sum;
import Model.Turtle;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException {
		Controller c = new Controller();
		c.init(100, 100);
		c.processCommand("fd sum 1 2");
	}
}
