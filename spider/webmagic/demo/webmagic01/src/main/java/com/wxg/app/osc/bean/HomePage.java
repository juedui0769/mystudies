package com.wxg.app.osc.bean;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("t_homepage")
public class HomePage {

	@Id
	private int id;
	
	@Column
	private String addTm;
	
	@Column
	private String title;
	
	@Column
	@ColDefine(width=300)
	private String url;
	
	@Column
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAddTm() {
		return addTm;
	}

	public void setAddTm(String addTm) {
		this.addTm = addTm;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "HomePage [id=" + id + ", addTm=" + addTm + ", title=" + title
				+ ", url=" + url + ", type=" + type + "]";
	}
	
	
	
}
