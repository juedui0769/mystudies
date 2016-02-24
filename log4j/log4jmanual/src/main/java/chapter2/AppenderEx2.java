package chapter2;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class AppenderEx2 {

	static public void main(String[] args) throws Exception {
		
		FileAppender a0 = new FileAppender(new SimpleLayout(), "a0.log");
		FileAppender a1 = new FileAppender(new SimpleLayout(), "a1.log");
		FileAppender secureAppender = new FileAppender(new SimpleLayout(), "secret.log");
		
		Logger root = Logger.getRootLogger();
		root.addAppender(a0);
		
		Logger x = Logger.getLogger("x");
		x.addAppender(a1);
		
		Logger xyz = Logger.getLogger("x.y.z");
		
		Logger secureLogger = Logger.getLogger("secure");
		secureLogger.addAppender(secureAppender);
		secureLogger.setAdditivity(false);
		
		// The accessLogger is a child of the secureLogger.
		Logger accessLogger = Logger.getLogger("secure.access");
		
		// Output goes to a0.log and a1.log.
		xyz.debug("Regular message.");
		
		// Output goes only to secret.log
		accessLogger.warn("Detected snooping attempt by Eve.");
		
	}
}
