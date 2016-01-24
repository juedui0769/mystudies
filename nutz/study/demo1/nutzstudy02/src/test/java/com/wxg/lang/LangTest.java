package com.wxg.lang;


import java.util.Arrays;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.nutz.lang.Lang;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LangTest {

	@Test
	public void testFields(){
		Assert.assertFalse(Lang.isAndroid);
	}
	
	@Test
	public void testArray(){
		String[] strs = Lang.array("a","b","c");
		Assert.assertEquals("[a, b, c]", Arrays.toString(strs));
	}
	
	
	
	
}
