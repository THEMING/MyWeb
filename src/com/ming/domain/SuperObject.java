package com.ming.domain;

import com.ming.annotation.MyAnnotation;
import com.ming.util.JedisUtils;

public abstract class SuperObject {

	private String Id;
	
	@MyAnnotation
	public final String save(){
		return JedisUtils.set(this.getId(), this);
	}
	
	public static final String get(String id){
		return JedisUtils.get(id);
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
}
