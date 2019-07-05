package com.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.service.UserService;
import com.system.utils.MyPage;
import com.system.utils.controllerUtil.ISearchCondition;

@Controller
@RequestMapping("/user")
@Api(value = "UserController|一个关于访问/跟新用户数据的控制器")
public class UserController extends BaseController{
	
	private static Logger logger=Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	    
    @Autowired
    private SqlSession sqlSession;
    
    /**
     * @return
     * 分页查询用户数据
     */
    @ResponseBody
    @GetMapping("/getUserByPage")
    @ApiOperation(value="根据用户条件筛选，获取分页后的用户数据",
    			  httpMethod ="GET",
    			  notes = "接口发布说明")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "page", value = "页码", required = false, dataType = ""),
        @ApiImplicitParam(paramType="query", name = "rows", value = "每页数目", required = false, dataType = "string"),
    })
    public MyPage getUsersByPage() {
    	ISearchCondition searchCodition = getSearchCodition();
    	MyPage queryUserByPage=null;
    	try {
        	 queryUserByPage = userService.queryUserByPage(searchCodition);
		} catch (Exception e) {
			logger.error("exception", e);
		}
        return queryUserByPage;
    }
    
    
    
    @RequestMapping("/uid")
    @ResponseBody
    String uid() {
    	//ISearchCondition searchCodition = getSearchCodition();
    	HttpSession session = this.getSession();
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
    
    
}
