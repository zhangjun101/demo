package com.system.controller;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.service.UserService;
import com.system.utils.MyPage;
import com.system.utils.controllerUtil.ISearchCondition;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);	

	 @Autowired
	 private UserService userService;
	    
    @Autowired
    private SqlSession sqlSession;
   
   
    
    /**
     * @return
     * 分页查询用户数据
     */
    @ResponseBody
    @RequestMapping("/getUserByPage")
    public MyPage getUsersByPage() {
    	ISearchCondition searchCodition = getSearchCodition();
    	MyPage queryAllUserInfo = userService.queryUserByPage(searchCodition);
        return queryAllUserInfo;
    }
    
    
    
}
