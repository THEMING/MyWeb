package com.ming.myenum;

public enum Sex {
	MALE("��"),FEMALE("Ů");
	private String name;
	private Sex(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
