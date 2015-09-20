package com.ming.util;

import java.util.UUID;

import net.sf.json.JSONObject;

import com.ming.domain.User;
import com.ming.myenum.Sex;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
	private static JedisPool jedisPool = null;
	
	public static JedisPool getJedisPool(){
		if(jedisPool==null){
			JedisPoolConfig jpc = new JedisPoolConfig();
			jpc.setMaxTotal(-1);
			jedisPool = new JedisPool(jpc, "120.132.147.139");
		}
		
		return jedisPool;
	}
	
	public static Jedis getJedis(){
		return getJedisPool().getResource();
	}
	
	public static String set(String key,Object value){
		Jedis jedis = getJedis();
		try{
			return jedis.set(key, JSONObject.fromObject(value).toString());
		}finally{
			if (jedis != null) {
			    jedis.close();
			  }
		}
	}
	
	public static String get(String key){
		Jedis jedis = getJedis();
		try{
			return getJedis().get(key);
		}finally{
			if (jedis != null) {
			    jedis.close();
			  }
		}
	}
	
	public static void main(String[] args) {
		User user = new User(UUID.randomUUID().toString(),"Jack",Sex.MALE);
		System.out.println(user.getId());
		System.out.println(JSONObject.fromObject(user).toString());
	}

}
