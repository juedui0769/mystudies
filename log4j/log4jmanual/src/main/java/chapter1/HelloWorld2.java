package chapter1;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class HelloWorld2 {

	static Logger logger = Logger.getLogger("chapter1.HelloWorld2");
	
	static public void main(String[] args) {
		BasicConfigurator.configure();
		logger.debug("Hello world.");
	}
}
