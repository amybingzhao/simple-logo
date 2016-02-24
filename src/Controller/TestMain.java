package Controller;

import Model.Sum;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException {
		Controller c = new Controller();
		c.init(100, 100);
		c.processCommand("sum 1 2");
		//Sum s = new Sum();
		//System.out.println(s.getClass().getName());
	}
}
