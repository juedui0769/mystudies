package chapter3;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class MyApp3 {
	
	final static Logger logger = Logger.getLogger(MyApp3.class);
	
	public static void main(String[] args){
		String bathpath = MyApp3.class.getResource("").getPath();
		
		DOMConfigurator.configure(bathpath+"sample0.xml");
		
		logger.info("Entering application.");
		Foo foo = new Foo();
		foo.doIt();
		logger.info("Exiting application");
	}

}
