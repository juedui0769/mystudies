package com.wxg;

import java.util.Arrays;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Test;

public class TestCommonsConfiguration {

	@Test
	public void hello(){
		
		String confLog4j = TestCommonsConfiguration.class.getResource("/log4j.properties").getPath();
		PropertiesConfiguration pc = null;
		try {
			pc = new PropertiesConfiguration( confLog4j );
			System.out.println( Arrays.toString(pc.getList("log4j.rootLogger").toArray()) );
			// log4j.logger.org.apache.commons.beanutils
			System.out.println( pc.getString("log4j.logger.org.apache.commons.beanutils") );
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		System.out.println( confLog4j );
	}
	
}
