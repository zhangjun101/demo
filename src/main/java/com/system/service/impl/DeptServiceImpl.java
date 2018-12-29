package com.system.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.controller.UserController;
import com.system.dao.DeptMapper;
import com.system.dao.UserMapper;
import com.system.domain.Dept;
import com.system.domain.User;
import com.system.service.DeptService;
import com.system.service.UserService;
import com.system.utils.MyPage;
import com.system.utils.controllerUtil.ISearchCondition;


@Component
public class DeptServiceImpl implements DeptService{
	
	private static Logger logger=Logger.getLogger(DeptServiceImpl.class);

	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public List<Dept> queryAllDeptUser(ISearchCondition searchCoditions) throws Exception{
		List<Dept> queryAllDeptUser = deptMapper.queryAllDeptUser();
		return queryAllDeptUser;
	}


}
