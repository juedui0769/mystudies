package chapter2;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LLF {

	static public void main(String[] args) {
		BasicConfigurator.configure();
		
		// get a logger instance name "com.foo"
		Logger logger = Logger.getLogger("com.foo");
		
		// Now set its level. Usually you do not need to set the level of
		// a logger programmatically but rather in a configuration script.
		// We do it here nonetheless for the purposes of this exercise.
		logger.setLevel(Level.INFO);
		
		Logger barLogger = Logger.getLogger("com.foo.Bar");
		
		// Nothing tha WARN is the level of this logging request whereas
		// INFO is logger's effective level, this request is enabled
		// because WARN >= INFO.
		logger.warn("Low fuel level.");
		
		// This request is disabled, because DEBUG < INFO.
		logger.debug("Starting search for nearest gas station.");
		
		// The logger instance barLogger, named "com.foo.Bar", will
		// inherit its level from the logger named "com.foo" Thus, the
		// following request is enabled because INFO >= INFO.
		barLogger.info("Located nearest gas station.");
		
		// This request is disabled, because DEBUG < INFO.
		barLogger.debug("Exiting gas station search");
	}
}
