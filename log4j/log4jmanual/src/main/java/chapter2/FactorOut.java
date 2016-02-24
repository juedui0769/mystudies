package chapter2;

import org.apache.log4j.Logger;

public class FactorOut {

	static final boolean D = false;
	static Logger logger = Logger.getLogger(FactorOut.class);
	
	void foo(int i) {
		if(D) logger.debug("Input parameter is :" + i);
	}
}
