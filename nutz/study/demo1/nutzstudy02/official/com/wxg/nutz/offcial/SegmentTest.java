package com.wxg.nutz.offcial;


import org.junit.Assert;
import org.junit.Test;
import org.nutz.lang.segment.CharSegment;
import org.nutz.lang.segment.Segment;

/**
 * http://www.nutzam.com/core/lang/segment.html
 * @author wxg
 *
 */
public class SegmentTest {

	@Test
	public void helloSegment(){
		Segment seg = new CharSegment("hello ${a}, I love you ${a}. ${b}");
		seg.set("a", "nutz").set("b", "good!");
		Assert.assertEquals("hello nutz, I love you nutz. good!", seg.toString());
		/**
		 * 官方提醒: 如果多线程共享一个 CharSegment，那么最好使用前复制一份
		 * Segment newSeg = seg.born();
		 */
	}
	
	
	
	
}
