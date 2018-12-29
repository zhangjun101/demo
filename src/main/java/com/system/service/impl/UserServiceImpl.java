package com.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.dao.UserMapper;
import com.system.domain.User;
import com.system.service.UserService;
import com.system.utils.MyPage;
import com.system.utils.controllerUtil.ISearchCondition;


@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public MyPage queryUserByPage(ISearchCondition searchCoditions) throws Exception {
		PageHelper.startPage(1, 2);
		List<User> queryAllUserInfo = userMapper.queryAllUserInfo();
		PageInfo page = new PageInfo(queryAllUserInfo);
		MyPage myPage = new MyPage();
		myPage.setTotal(page.getTotal());  //总记录数
		myPage.setTotalPage(page.getPages());//总页数
		myPage.setPage(page.getPageNum());   //当前页
		myPage.setRows(queryAllUserInfo);
		return myPage;
	}


}
