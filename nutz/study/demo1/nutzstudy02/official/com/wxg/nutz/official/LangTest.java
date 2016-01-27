package com.wxg.nutz.official;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.nutz.lang.Dumps;
import org.nutz.lang.Each;
import org.nutz.lang.Lang;

import com.wxg.bean.Person;

/**
 * http://www.nutzam.com/core/lang/lang.html
 * 
 * 这个类虽然命名LangTest但是并不是仅仅测试org.nutz.lang.Lang
 * @author wxg
 *
 */
@org.junit.FixMethodOrder(org.junit.runners.MethodSorters.NAME_ASCENDING)
public class LangTest {

	/**
	 * 异常
	 */
	
	@Test
	public void objTools(){
		/**
		 * 比较对象: 支持数组，集合，和容器
		 * 看看下面的测试,我感觉, Lang.equals 方法比较鸡肋. 可以寻求其他的框架代替.
		 */
		String aa = "111";
		String bb = "111";
		Person p1 = new Person("nutz", 5, "男");
		Person p2 = new Person("nutz", 5, "男");
		Assert.assertTrue(Lang.equals(aa, bb));
		Assert.assertFalse(Lang.equals(p1, p2));
		String[] arr1 = Lang.array("11", "22", "33");
		String[] arr2 = Lang.array("11", "22", "33");
		Assert.assertTrue(Lang.equals(arr1, arr2));
		List<Person> list1 = new ArrayList<Person>();
		List<Person> list2 = new ArrayList<Person>();
		list1.add(new Person("wxg", 32, "男"));
		list2.add(new Person("wxg", 32, "男"));
		Assert.assertFalse(Lang.equals(list1, list2));
		
		/**
		 * 显示对象
		 */
		String outputstr = Dumps.obj(p1);
		Assert.assertTrue( outputstr.contains("com.wxg.bean.Person") );
		
		/**
		 * 是否包括
		 */
		Assert.assertTrue( Lang.contains(arr1, "11") );
		
		/**
		 * 遍历
		 */
		Lang.each(p1, new Each<Object>(){
			public void invoke(int i, Object ele, int length){
				Assert.assertEquals("Person [name=nutz, age=5, sex=男]", ele.toString());
			}
		});
		Lang.each(arr1, new Each<Object>(){
			public void invoke(int i, Object ele, int length){
				if (i==0){
					Assert.assertEquals("11", ele.toString());
				}
			}
		});
		
	}
	
	@Test
	public void containerTools(){
		/**
		 * 数组 to Map
		 */
		Person[] persons = new Person[2];
		persons[0] = new Person("java", 20, "男");
		persons[1] = new Person("javascript", 19, "女");
		@SuppressWarnings("unchecked")
		Map<String, Person> personMap = Lang.array2map(HashMap.class, persons, "name");
		Assert.assertEquals(
				"{javascript=Person [name=javascript, age=19, sex=女], java=Person [name=java, age=20, sex=男]}"
				, personMap.toString());
		
		/**
		 * 数组 to 数组
		 */
		String[] strArr = (String[]) Lang.array2array(persons, String.class);
		Assert.assertEquals("Person [name=java, age=20, sex=男]", strArr[0]);
		
		/**
		 * 剩下的可以去看文档: http://www.nutzam.com/core/lang/lang.html
		 * 
		 * 集合 to 数组
		 * 集合 to 列表
		 * 集合 to Map
		 * Map to 对象
		 */
		
	}
	
	@Test
	public void objSimulation(){
		/**
		 * 生成数组
		 */
		String[] ss = Lang.array("aa", "bb", "cc");
		Assert.assertEquals("[aa, bb, cc]", Arrays.toString(ss));

		/**
		 * 从字符串生成Map
		 */
		Map<String,Object> map = Lang.map("{a:10, b:'ABC', c:true}");
		Assert.assertEquals("{a=10, b=ABC, c=true}", map.toString());
		
		/**
		 * 从字符串生成 List
		 * 感觉很鸡肋, 是我不会用,还是API很鸡肋呢?
		 */
		List<String> list = Lang.list("['aa', 'bb', 'ABC']");
		Assert.assertEquals("['aa', 'bb', 'ABC']", list.get(0).toString());
		
	}
	
	/**
	 * 其他的就不测试了, 要用看文档吧.
	 */
	
}
