package com.wxg.lang.util;

import org.junit.Test;
import org.nutz.lang.util.SimpleContext;

import com.wxg.bean.Person;

/**
 * 
 * http://tool.oschina.net/uploads/apidocs/nutz-1.b.44/org/nutz/lang/util/Context.html
 * 
 * org.nutz.lang.util.Context 是一个接口.
 * 
 * @author wxg
 *
 */
public class ContextTest {

	@Test
	public void test1(){
		/**
		 * http://tool.oschina.net/uploads/apidocs/nutz-1.b.44/org/nutz/lang/util/SimpleContext.html
		 */
		SimpleContext sc = new SimpleContext();
		sc.set("wxg", new Person("wxg",32,"男"));
		System.out.println( sc.get("wxg") );
	}
}
