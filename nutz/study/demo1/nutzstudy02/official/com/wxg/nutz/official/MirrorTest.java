package com.wxg.nutz.official;


import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.nutz.lang.Mirror;

import com.wxg.bean.Pet;

/**
 * http://www.nutzam.com/core/lang/mirror.html
 * @author wxg
 *
 */
public class MirrorTest {

	@Test
	public void helloMirror(){
		Pet pet = Mirror.me(Pet.class).born("xiaobai");
		Assert.assertEquals("xiaobai", pet.getName());
		
		Pet pet2 = Mirror.me(Pet.class).born("XiaoBai", "2008-10-12 12:23:24");
		Assert.assertEquals(2008, pet2.getBirthday().get(Calendar.YEAR));
		
		Mirror<Pet> mirror = Mirror.me(Pet.class);
		Pet pet3 = mirror.born("小黑");
		String getname = (String)mirror.invoke(pet3, "getName", null);
		Assert.assertEquals("小黑", getname);
	}
}
