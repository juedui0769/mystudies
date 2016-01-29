package com.wxg.nutz.official.dao;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;

import com.wxg.nutz.official.dao.bean.Person;


public class SimpleDataSourceStudy {

	public static void main(String[] args) {
		SimpleDataSource ds = new SimpleDataSource();
		ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/nutzbook");
		ds.setUsername("root");
		ds.setPassword("root");
		
		Dao dao = new NutDao(ds);
		dao.create(Person.class, false);
		
		//
		
		Person p = dao.fetch(Person.class,4);
		System.out.println(p.getName());
		
		
	}
}
