package com.wxg.junitdemo.me;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 
 * 进阶阅读: https://github.com/junit-team/junit/wiki/Exception-testing
 * @author wxg
 *
 */
public class ExpectedExceptions {

	@Test(expected = IndexOutOfBoundsException.class)
	public void empty(){
		new ArrayList<Object>().get(0);
	}
	
}
