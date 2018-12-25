package com.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.system.domain.User;
import com.system.service.UserService;
import com.system.utils.MyPage;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);	

	
    @RequestMapping("/login")
    public String login() {
        return "system/jsp/login/login";
    }
    
    
    @RequestMapping("/userLogin")
    @ResponseBody
    public String userLogin() {
        return "system/jsp/main/main";
    }
    
    @RequestMapping("/loginToMain")
    public String loginToMain() {
        return "system/jsp/main/main";
    }
    
    @Autowired
    private SqlSession sqlSession;
    
    
//    @ResponseBody
//    @RequestMapping("/getUser")
//    public List<User> getUsersByPage() {
//        PageHelper.startPage(1, 3);
//        List<User> pagelist = this.sqlSession.selectList("queryAllUserInfo");
//        return pagelist;
//    }
    @Autowired
    private UserService userService;
    

    
}
