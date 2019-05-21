package com.example.demo;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.system.utils.RedisUtils;



@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RedisTest {
	
	@Resource
	private RedisUtils redisUtils;
 
	/**
	 * 插入缓存数据
	 */
	@Test
	public void set() {
		redisUtils.set("redis_key", "redis_vale");
	}
	
	/**
	 * 读取缓存数据
	 */
	@Test
	public void get() {
		String value = redisUtils.get("redis_key");
		System.out.println(value);
	}
 
}
