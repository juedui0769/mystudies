package chapter3;

import org.apache.log4j.Logger;

public class Foo {

	static final Logger logger = Logger.getLogger(Foo.class);
	
	public void doIt() {
		logger.debug("Did it again!");
	}
}
