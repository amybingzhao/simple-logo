package Controller;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException {
		Controller c = new Controller();
		c.init(100, 100);
		c.processCommand("less?	\t \n sum 1 2 50");
	}
}
