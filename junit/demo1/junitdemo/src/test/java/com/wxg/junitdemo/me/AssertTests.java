package com.wxg.junitdemo.me;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * 官网: http://junit.org/
 * @author wxg
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssertTests {

	@Test
	public void assertArrayEquals(){
		/**
		 * 可以接受两个或三个参数.
		 * 九种类型的数组: boolean[], byte[], char[], int[], long[], Object[], short[], double[], float[]
		 */
		Assert.assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
	}
	
	@Test
	public void assertEquals(){
		/**
		 * 当比较double类型时,两个参数的比较不出来.必须传递第三个参数delta .
		 * 参考: http://junit.org/javadoc/latest/index.html
		 */
		Assert.assertEquals(0.12d, 0.12d, 2);
		Assert.assertEquals(Double.NaN, Double.NaN, 2);
	}
	
	@Test
	public void assertFalse(){
		Assert.assertFalse( 1==2 );
	}
	
	
	@Test
	public void assertNotEquals(){
		/**
		 * (1)long,Object,double,float
		 * (2)同上,多第一个参数 -> String message
		 */
		Assert.assertNotEquals(12L, 11L);
	}
	
	@Test
	public void assertNotNull(){
		Assert.assertNotNull("111");
	}
	
	@Test
	public void assertNotSame(){
		Assert.assertNotSame("111", "222");
	}
	
	@Test
	public void assertNull(){
		Assert.assertNull(null);
	}
	
	@Test
	public void assertSame(){
		Assert.assertSame("111", "111");
	}
	
	@Test
	public void assertThat(){
		/**
		 * Assert.assertThat
		 * 
		 * http://www.360doc.com/content/13/1225/13/11253639_339982629.shtml
		 */
		
	}
	
	@Test
	public void assertTrue(){
		Assert.assertTrue( true );
	}
	
	@Test
	public void fail(){
//		Assert.fail();
	}
	
}
