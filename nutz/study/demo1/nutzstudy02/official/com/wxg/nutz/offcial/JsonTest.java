package com.wxg.nutz.offcial;


import org.junit.Assert;
import org.junit.Test;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import com.wxg.bean.Pet;

/**
 * http://www.nutzam.com/core/json/base.html
 * @author wxg
 *
 */
public class JsonTest {

	@Test
	public void jsonBase(){
		Pet pet = new Pet();
		pet.setName("dongdong");
		pet.setAge(10);
		/**
		 * JsonFormat
		 * http://www.nutzam.com/core/json/to.html
		 */
		Assert.assertEquals("{\"name\":\"dongdong\",\"age\":10}", Json.toJson(pet, JsonFormat.compact()));
	}
}
