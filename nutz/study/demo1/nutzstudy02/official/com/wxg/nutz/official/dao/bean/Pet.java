package com.wxg.nutz.official.dao.bean;

import java.util.Calendar;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("t_pet")
public class Pet {

	@Id
	private int id;
	
	@Name
	private String name;

	@Column
    private Calendar birthday;
	
	@Column
    private String nickname;
	
	public Pet(){}
	
	public Pet(String name){
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", birthday=" + birthday
				+ ", nickname=" + nickname + "]";
	}



	
}
