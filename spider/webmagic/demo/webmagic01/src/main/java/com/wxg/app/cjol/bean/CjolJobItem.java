package com.wxg.app.cjol.bean;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("t_cjol_job")
public class CjolJobItem {
	
	@Id
	private long id;
	
	/**
	 * 职位名称: 软件工程师
	 */
	@Column
	private String position;
	
	/**
	 * 公司名称
	 */
	@Column
	private String corporation;
	
	/**
	 * 公司网站
	 */
	@Column
	@ColDefine(width=300)
	private String officialurl;
	
	/**
	 * 工作地区
	 */
	@Column
	private String region;
	
	/**
	 * 性别
	 */
	@Column
	private String gender;
	
	/**
	 * 学历
	 */
	@Column
	private String education;
	
	/**
	 * 经验
	 */
	@Column
	private String experience;
	
	/**
	 * 月薪
	 */
	@Column
	private String salary;
	
	/**
	 * 更新时间
	 */
	@Column
	private String updatTm;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getUpdatTm() {
		return updatTm;
	}

	public void setUpdatTm(String updatTm) {
		this.updatTm = updatTm;
	}

	public String getOfficialurl() {
		return officialurl;
	}

	public void setOfficialurl(String officialurl) {
		this.officialurl = officialurl;
	}

	@Override
	public String toString() {
		return "CjolJobItem [id=" + id + ", position=" + position
				+ ", corporation=" + corporation + ", officialurl="
				+ officialurl + ", region=" + region + ", gender=" + gender
				+ ", education=" + education + ", experience=" + experience
				+ ", salary=" + salary + ", updatTm=" + updatTm + "]";
	}

	
	
	
}
