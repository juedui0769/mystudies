package com.wxg.nutz.official.dao;

import java.util.Date;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;

import com.wxg.nutz.official.dao.bean.Person;


public class SimpleDataSource4Sqlserver {

	public static void main(String[] args) {
		SimpleDataSource ds = new SimpleDataSource();
		ds.setJdbcUrl("jdbc:sqlserver://localhost:1433;DatabaseName=HIS_HD");
		ds.setUsername("sa");
		ds.setPassword("hisadmin");
		
		Dao dao = new NutDao(ds);
		dao.create(Person.class, false);
		Person pp = new Person();
		pp.setName("wxg"+(new Date().getTime()));
		pp.setAge(32);
		dao.insert(pp);
		
		//
		int count = dao.count(Person.class);
		System.out.println(count);
	}
}
