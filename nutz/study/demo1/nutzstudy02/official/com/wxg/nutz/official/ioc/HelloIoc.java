package com.wxg.nutz.official.ioc;



import org.junit.Assert;
import org.junit.Test;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

import com.wxg.nutz.official.ioc.bean.Pet;



/**
 * http://www.nutzam.com/core/ioc/hello.html
 * @author wxg
 *
 */
public class HelloIoc {

	@Test
	public void helloPet(){
		Ioc ioc = new NutIoc(new JsonLoader("com/wxg/nutz/official/ioc/bean/pets.js"));
		Pet pet = ioc.get(Pet.class, "xiaobai");
		Assert.assertEquals("XiaoBai", pet.getName());
		Assert.assertEquals("Asia/Shanghai", pet.getBirthday().getTimeZone().getID());
		/**
		 * 如果配置文件中声明了类型，则可不传入类型
		 */
		Pet xh = ioc.get(null, "xiaohei");
		Assert.assertEquals("XiaoHei", xh.getName());
		Assert.assertEquals("XiaoBai", xh.getFriend().getName());
		/**
		 * 声明了 singleton: false，那么它每次获取，都会生成一个新的实例
		 */
		Pet xh1 = ioc.get(null, "xiaohei");
		Pet xh2 = ioc.get(null, "xiaohei");
		Assert.assertFalse(xh1==xh2);
	}
	
	@Test
	public void innerObject(){
		/**
		 * http://www.nutzam.com/core/ioc/inner_object.html
		 */
		Ioc ioc = new NutIoc(new JsonLoader("com/wxg/nutz/official/ioc/bean/inner.js"));
		Pet pet = ioc.get(Pet.class, "xb");
		Assert.assertEquals("XiaoHei", pet.getFriend().getName());
	}
	
	@Test
	public void events(){
		Ioc ioc = new NutIoc(new JsonLoader("com/wxg/nutz/official/ioc/bean/events.js"));
		Pet pet = ioc.get(Pet.class, "xb");
		ioc.get(Pet.class, "xb");
		ioc.get(Pet.class, "xb");
		Assert.assertEquals(3, pet.getFetchCount());
		Assert.assertEquals("XiaoBai", pet.getName());
	}
	
	@Test
	public void events2(){
		Ioc ioc = new NutIoc(new JsonLoader("com/wxg/nutz/official/ioc/bean/events2.js"));
		Pet pet = ioc.get(Pet.class, "xh");
		ioc.get(Pet.class, "xh");
		Assert.assertEquals(2, pet.getFetchCount());
	}
	
}
