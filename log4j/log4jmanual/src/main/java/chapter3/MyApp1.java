package chapter3;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class MyApp1 {

	final static Logger logger = Logger.getLogger(MyApp1.class);
	
	public static void main(String[] args) {
		// Set up a simple configuration that logs on the console.
		BasicConfigurator.configure();
		
		logger.info("Entering application.");
		Foo foo = new Foo();
		foo.doIt();
		logger.info("Exiting application.");
	}
}
