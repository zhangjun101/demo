package com.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.system.domain.Dept;

/**
 * @author ZHANGJUN
 * 部门接口类
 */

@Mapper
public interface DeptMapper {
	
	
	/**
	 * 查询所有的部门（包含员工信息集合）
	 * @return list<User>
	 */
	public List<Dept> queryAllDeptUser() throws Exception;
	
	
	
	
}
