package com.wxg.nutz.offcial;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.nutz.castor.Castors;
import org.nutz.lang.meta.Email;

/**
 * http://www.nutzam.com/core/lang/castors.html
 * @author wxg
 *
 */
public class CastorsTest {

	@Test
	public void helloCastors(){
		int aa = Castors.me().castTo("9527", int.class);
		Assert.assertEquals(95270, aa*10);
		
		Email email = Castors.me().castTo("zozohtnt@gmail.com", Email.class);
		Assert.assertEquals("zozohtnt", email.getAccount());
		
		Calendar calendar = Castors.me().castTo("2016-1-27 00:19:07", Calendar.class);
		Assert.assertEquals(2016, calendar.get(Calendar.YEAR));
	
	}
}
