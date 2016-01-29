package com.wxg.nutz.official.dao;

import javax.sql.DataSource;

import org.junit.Test;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import com.wxg.nutz.official.dao.bean.Pet;

/**
 * http://www.nutzam.com/core/dao/transaction.html
 * @author wxg
 *
 */
public class TransactionTest {

	@Test
	public void helloTransaction(){
		Ioc ioc = new NutIoc(new JsonLoader("com/wxg/nutz/official/dao/druid.js"));
		DataSource ds = ioc.get(null, "dataSource");
		final Dao dao = new NutDao(ds);
		dao.create(Pet.class, false);
		
		//
		if ( null == dao.fetch(Pet.class,"XiaoBai") ){
			dao.insert(new Pet("XiaoBai"));
		}
		if ( null == dao.fetch(Pet.class,"XiaoHei") ){
			dao.insert(new Pet("XiaoHei"));
		}
		
		//
		final Pet pet1 = dao.fetch(Pet.class,"XiaoBai");
		final Pet pet2 = dao.fetch(Pet.class,"XiaoHei");
		
		pet1.setNickname("BaiBai");
		pet2.setNickname("HeiHei");
		
		Trans.exec(new Atom(){
			public void run(){
				dao.update(pet1);
				dao.update(pet2);
			}
		});
		
		
		System.err.println( pet1 );
		System.err.println( pet2 );
	}
}
