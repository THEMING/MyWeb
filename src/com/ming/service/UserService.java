package com.ming.service;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ming.domain.User;
import com.ming.util.JedisUtils;

import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/user")
public class UserService {

	@RequestMapping(value="/addUser",method = RequestMethod.POST)
	public String addUser(@RequestBody User user){
		return user.save();
	}
	
	@RequestMapping(value="/getUser",method = RequestMethod.POST)
	public String getUser(@RequestBody Map<String,String> key){
		return JedisUtils.get(MapUtils.getString(key,"key"));
	}
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis("120.132.147.139");
		jedis.set("foo", "bar");
		String value = jedis.get("aa");
		System.out.println(value);
		
	}
}
