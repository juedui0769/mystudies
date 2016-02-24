package chapter2;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class AppenderEx1 {

	static public void main(String[] args) throws Exception{
		
		FileAppender a0 = new FileAppender(new SimpleLayout(), "a0.log");
		FileAppender a1 = new FileAppender(new SimpleLayout(), "a1.log");
		
		Logger root = Logger.getRootLogger();
		root.addAppender(a0);
		
		Logger x = Logger.getLogger("x");
		x.addAppender(a1);
		
		Logger xyz = Logger.getLogger("x.y.z");
		
		// Note that we have not added any appenders to the xyz logger.
		xyz.debug("Some message.");
		xyz.info("Another message.");
	}
	
}
