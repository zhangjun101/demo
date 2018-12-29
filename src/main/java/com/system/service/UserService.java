package com.system.service;


import com.system.utils.MyPage;
import com.system.utils.controllerUtil.ISearchCondition;


/**
 * @author ZHANGJUN
 * 用户service
 */
public interface UserService {
	
	/**
	 * @return list<User>
	 * 分页查询所有的用户信息
	 */
	public MyPage queryUserByPage(ISearchCondition searchCodition) throws Exception;
}
