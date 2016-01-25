package com.wxg.javaapi.util;

import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * 
 * http://tool.oschina.net/uploads/apidocs/jdk-zh/java/util/Formatter.html#syntax
 * 
 * @author wxg
 *
 */
public class FormatterTest {

	@Test
	public void test1(){
		/**
		 * 显式索引
		 */
		System.out.println("显式索引");
		String str = (new Formatter()).format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d").toString();
		System.out.println(str);
		System.out.println("---");
		str = (new Formatter()).format("%4$s %3$s %2$s %1$s %4$s %3$s %2$s %1$s","a", "b", "c", "d").toString();
		System.out.println(str);
		System.out.println("---");
		
		/**
		 * 相对索引
		 */
		System.out.println("相对索引");
		str = (new Formatter()).format("%s %s %<s %<s", "a", "b", "c", "d").toString();
		System.out.println(str);
		
		/**
		 * 普通索引
		 */
		System.out.println("普通索引");
		str = (new Formatter()).format("%s %s %s %s", "a", "b", "c", "d").toString();
		System.out.println(str);
		
		System.out.format("Local time: %tT", Calendar.getInstance());
		
		System.err.printf("\r\nUnable to open file '%1$s': %2$s", "nutz", "nutz.org");
		
		Calendar c = new GregorianCalendar(1995, Calendar.MAY, 23);
		String s = String.format("\r\nDuke's Birthday: %1$tm %1$te,%1$tY", c);
		System.out.println( s );
	}
	
}

