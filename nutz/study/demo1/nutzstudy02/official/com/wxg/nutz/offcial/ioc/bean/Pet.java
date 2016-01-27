package com.wxg.nutz.offcial.ioc.bean;

import java.util.Calendar;

public class Pet {

	private String name;

    private Calendar birthday;

    private Pet friend;
    
    private int fetchCount;

    public Pet() {}

    public Pet(String name) {
        this.name = name;
    }

    public void onFetch(){
    	this.fetchCount++;
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

	public Pet getFriend() {
		return friend;
	}

	public void setFriend(Pet friend) {
		this.friend = friend;
	}

	public int getFetchCount() {
		return fetchCount;
	}

	public void setFetchCount(int fetchCount) {
		this.fetchCount = fetchCount;
	}
    
    
}
