package com.system.service;


import java.util.List;

import com.system.domain.Dept;
import com.system.utils.controllerUtil.ISearchCondition;


/**
 * @author ZHANGJUN
 * 用户service
 */
public interface DeptService {
	
	/**
	 * @return list<User>
	 * 查询所有的部门信息
	 */
	public List<Dept> queryAllDeptUser(ISearchCondition searchCodition) throws Exception;
}
