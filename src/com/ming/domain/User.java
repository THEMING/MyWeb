package com.ming.domain;


import com.ming.myenum.Sex;

public class User extends SuperObject{
	
	private String name;
	
	private Sex sex;
	
	public User(){}
	
	public User(String id,String name,Sex sex){
		this.setId(id);
		this.name = name;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

}
