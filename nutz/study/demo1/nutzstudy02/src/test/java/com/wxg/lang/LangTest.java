package com.wxg.lang;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.nutz.lang.Each;
import org.nutz.lang.Lang;
import org.nutz.lang.MapKeyConvertor;

import com.wxg.bean.Person;

/**
 * http://tool.oschina.net/uploads/apidocs/nutz-1.b.44/org/nutz/lang/Lang.html
 * @author wxg
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LangTest {

	@Test
	public void testFields(){
		Assert.assertFalse(Lang.isAndroid);
	}
	
	@Test
	public void testArray(){
		String[] strs = Lang.array("a","b","c");
		String[] arr = new String[]{"a","b","c"};
		Assert.assertArrayEquals(strs, arr);
		Assert.assertEquals("[a, b, c]", Arrays.toString(strs));
	}
	
	@Test
	public void array2array(){
		String[] strs = Lang.array("11","22","33");
		int[] arr2 = new int[]{11,22,33};
		int[] intarr = (int[]) Lang.array2array(strs, int.class);
		/**
		 * Assert.assertEquals
		 * Assert.assertArrayEquals
		 * 这里要使用"assertArrayEquals", 而不是"assertEquals"
		 */
		Assert.assertArrayEquals(arr2, intarr);
	}
	
	@Test
	public void array2list(){
		String[] strs = Lang.array("11","22","33");
		List<String> strlist = Lang.array2list(strs);
		List<String> list = new ArrayList<String>();
		list.add("11");
		list.add("22");
		list.add("33");
		/**
		 * 这里可以使用"Assert.assertEquals"来判断.
		 */
		Assert.assertEquals(strlist, list);
	}
	
	@Test
	public void collection2array(){
		List<String> list = new ArrayList<String>();
		list.add("11");
		list.add("22");
		list.add("33");
		Assert.assertArrayEquals( list.toArray(), Lang.collection2array(list) );
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void array2map(){
		/**
		 * 下面的测试是没意义的. 
		 * Lang.array2map 主要是针对用户定义的对象的. 譬如Person,Pet...
		 */
		@SuppressWarnings("unused")
		String[] strs = Lang.array("11","22","33");
		//Map<String,String> map = Lang.array2map(HashMap.class, strs, "name");
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("nutz",2,"男"));
		persons.add(new Person("java",15,"男"));
		persons.add(new Person("javascript",15,"男"));
		
		/**
		 * 看下面的使用. "Lang.array2map"在抽取某个对象的某个字段作key时,还是比较方便的.
		 */
		Map<String, Person> map = Lang.array2map(HashMap.class, persons.toArray(), "name");
		//System.out.println(map.keySet());
		Assert.assertEquals("[javascript, nutz, java]", map.keySet().toString());
	}
	
	@Test
	public void arrayFirst(){
		String[] strs = Lang.array("11","22","33");
		String[] arr = Lang.arrayFirst("00", strs);
		Assert.assertEquals("[00, 11, 22, 33]", Arrays.toString(arr));
	}
	
	@Test
	public void arrayLast(){
		String[] strs = Lang.array("11","22","33");
		String[] arr = Lang.arrayLast(strs, "00");
		Assert.assertEquals("[11, 22, 33, 00]", Arrays.toString(arr));
	}
	
	@Test
	public void arrayUniq(){
		String[] strs = Lang.arrayUniq("11","22","33", "11","22");
		Assert.assertEquals("[11, 22, 33]", Arrays.toString(strs));
	}
	
	@Test
	public void concat(){
		/**
		 * "Lang.concat"有很多重载的方法
		 */
		String[] strs = Lang.array("11","22","33", "44","55");
		Assert.assertEquals("1122334455", Lang.concat(strs).toString());
	}
	
	@Test
	public void concatBy(){
		/**
		 * "Lang.concatBy"利用了"String.format"
		 * "java.util.Formatter" -> http://tool.oschina.net/uploads/apidocs/jdk-zh/java/util/Formatter.html#syntax
		 * @see com.wxg.javaapi.util.FormatterTest
		 */
		String[] strs = Lang.array("11","22","33", "44","55");
		Assert.assertEquals("11 22 33 44 55 ", Lang.concatBy("%s ", strs).toString());
		Assert.assertEquals("11, 22, 33, 44, 55, ", Lang.concatBy("%s, ", strs).toString());
	}
	
	@Test
	public void contains(){
		String[] strs = Lang.array("11","22","33", "44","55");
		Assert.assertTrue( Lang.contains(strs, "11") );
	}
	
	@Test
	public void convertMapKey(){
		/**
		 * convertMapKey(Object obj, MapKeyConvertor mkc, boolean recur)
		 * 第三个参数代表是否递归.
		 */
		Map<String,String> map = new HashMap<String,String>();
		map.put("aa", "11");
		map.put("bb", "22");
		map.put("cc", "33");
		Assert.assertEquals("{aa=11, bb=22, cc=33}", map.toString());
		Lang.convertMapKey(map, new MapKeyConvertor(){
			public String convertKey(String key){
				return key+"->";
			}
		}, false);
		Assert.assertEquals("{bb->=22, cc->=33, aa->=11}", map.toString());
	}
	
	@Test
	public void each(){
		String[] strs = Lang.array("11","22","33");
		final List<String> list = new ArrayList<String>();
		Lang.each(strs, new Each<String>(){
			public void invoke(int i, String ele, int length){
				list.add(ele+"00");
			}
		});
		Assert.assertEquals("[11, 22, 33]", Arrays.toString(strs));
		Assert.assertEquals("[1100, 2200, 3300]", Arrays.toString(list.toArray()));
	}
	
	@Test
	public void equals(){
		String[] strs = Lang.array("11","22","33");
		String[] strs2 = Lang.array("11","22","33");
		//Assert.assertArrayEquals(strs, strs2);
		Assert.assertTrue(Lang.equals(strs, strs2));
	}
	
	/**
	 * 写到这里,发现原来发下的愿望太大了: 把nutz的每个API都测试一遍.以期掌握nutz.
	 * 现在决定. 缩小愿望: 把一些重要的API测试下. 经常翻阅API文档. 发现新的重要的,再加入进来.
	 */
}
