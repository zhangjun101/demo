package com.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.system.domain.User;

/**
 * @author ZHANGJUN
 * 用户service接口类
 */

@Mapper
public interface UserMapper {
	
	
	/**
	 * 查询所有的用户信息
	 * @return list<User>
	 */
	public List<User> queryAllUserInfo();
	
	
	
	
}
