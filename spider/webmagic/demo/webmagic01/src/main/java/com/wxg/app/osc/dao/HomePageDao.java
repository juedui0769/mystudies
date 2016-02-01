package com.wxg.app.osc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import com.wxg.app.osc.bean.HomePage;

public class HomePageDao {

	public void save(final List<HomePage> homepages){
		Ioc ioc = new NutIoc(new JsonLoader("com/wxg/dao/druid.js"));
		DataSource ds = ioc.get(null, "dataSource");
		final Dao dao = new NutDao(ds);
		dao.create(HomePage.class, false);
		
		/**
		 * 事务控制
		 */
		Trans.exec(new Atom(){
			public void run(){
				for(HomePage hp : homepages){
					dao.insert(hp);
				}
			}
		});
		
		
	}
}
