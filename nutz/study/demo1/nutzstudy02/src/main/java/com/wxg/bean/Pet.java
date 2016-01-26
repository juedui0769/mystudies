package com.wxg.bean;

import java.util.Calendar;

public class Pet {
	private String name;
	private Calendar birthday;
	private int age;
	

	public Pet(){}
	
	public Pet(String name, Calendar birthday) {
		this.name = name;
		this.birthday = birthday;
	}

	public Pet(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
