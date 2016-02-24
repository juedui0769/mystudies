package chapter2;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerRepository;

public class HWT {

	static public void main(String[] args) {
		
		BasicConfigurator.configure();
		
		Logger x = Logger.getLogger("foo.bar");
		x.setLevel(Level.INFO);
		
		// get the containing repository
		LoggerRepository repository = x.getLoggerRepository();
		
		// Set the hierarchy-wide threshold to WARN effectively disabling
		// all INFO and DEBUG requests.
		repository.setThreshold(Level.WARN);
		
		// This request will be dropped because the hierarchy-wide
		// threshold is set to WARN even if the logger x is enabled for
		// the INFO level.
		x.info("Dropped message.");
		
		// Now, let us disable all levels. This will turn off logging
		// entirely, i.e. nothing will ever log.
		repository.setThreshold(Level.OFF);
		
		// This FATAL level request will be dropped because all levels
		// are turned off.
		x.fatal("This is a serious message but it will also be dropped.");
		
		// Now, let us set the hierarchy-wide threshold to ALL, the lowest
		// possible level. All requests will now pass unhindered through
		// the hierarchy-wide filter.
		repository.setThreshold(Level.ALL);
		
		// This request will be logged because the hierarchy-wide
		// threshold is set to ALL and the logger x is enabled for the
		// INFO level.
		x.info("Hello world.");
		
		// The logger-level filter will cause the following request to be
		// dropped. Indeed, the logger level (INFO) is higher than the 
		// request level (DEBUG).
		x.debug("Remember: DEBUG < INFO.");
	}
}
