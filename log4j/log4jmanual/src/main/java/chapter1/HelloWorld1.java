package chapter1;

import org.apache.log4j.Logger;

public class HelloWorld1 {

	static Logger logger = Logger.getLogger("chapter1.HelloWorld1");
	
	static public void main(String[] args) {
		logger.debug("Hello world.");
	}
}
