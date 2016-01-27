package com.wxg.nutz.official.dao;

import javax.sql.DataSource;

import org.junit.Test;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

import com.wxg.nutz.official.dao.bean.Person;


/**
 * http://www.nutzam.com/core/appendix/create_datasource.html
 * @author wxg
 *
 */
public class DruidTest {

	@Test
	public void helloDruid(){
		Ioc ioc = new NutIoc(new JsonLoader("com/wxg/nutz/official/dao/druid.js"));
		DataSource ds = ioc.get(null, "dataSource");
		Dao dao = new NutDao(ds);
		int count = dao.count(Person.class);
		System.out.println( count );
	}
	
}
