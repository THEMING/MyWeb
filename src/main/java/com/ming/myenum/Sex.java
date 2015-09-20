package com.ming.myenum;

public enum Sex {
	MALE("ÄÐ"),FEMALE("Å®");
	private String name;
	private Sex(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
