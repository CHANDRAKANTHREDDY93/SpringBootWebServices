package com.chand.demo.data;

import java.util.Date;

public class User {
	
	private int id;
	private String name;
	private Date dateofBirth;
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
	public Date getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public User(int id, String name, Date dateofBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateofBirth = dateofBirth;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateofBirth=" + dateofBirth + "]";
	}
	
	
	

}
