package com.wxg.nutz.official.dao;

import javax.sql.DataSource;

import org.junit.Test;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.Record;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

/**
 * http://www.nutzam.com/core/dao/record.html
 * @author wxg
 *
 */
public class RecordTest {

	@Test
	public void helloRecord(){
		Ioc ioc = new NutIoc(new JsonLoader("com/wxg/nutz/official/dao/druid.js"));
		DataSource ds = ioc.get(null, "dataSource");
		Dao dao = new NutDao(ds);
		Record re = dao.fetch("t_pet", Cnd.where("id","=",2));
		System.err.println(re.getString("name"));
	}
}
