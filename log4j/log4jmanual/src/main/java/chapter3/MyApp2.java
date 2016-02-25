package chapter3;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyApp2 {

	final static Logger logger = Logger.getLogger(MyApp2.class);
	
	public static void main(String[] args) {
		
		String bathpath = MyApp2.class.getResource("").getPath();

		// 和原书例子有所不同的在这里: sample0.properties 文件的位置得包装下.否则程序找不到文件.
		// PropertyConfigurator.configure(bathpath+"sample0.properties");
		// PropertyConfigurator.configure(bathpath+"substitution.properties");
		// PropertyConfigurator.configure(bathpath+"sample1.properties");
		// PropertyConfigurator.configure(bathpath+"sample5.properties");
		// PropertyConfigurator.configure(bathpath+"multiple.properties");
		// PropertyConfigurator.configure(bathpath+"duplicate.properties");
		// PropertyConfigurator.configure(bathpath+"restricted.properties");
		PropertyConfigurator.configure(bathpath+"additivityFlag.properties");
		
		logger.info("Entgering application.");
		Foo foo = new Foo();
		foo.doIt();
		logger.info("Exiting application.");
		
	}
	
	
}
