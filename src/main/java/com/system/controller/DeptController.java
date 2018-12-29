package com.system.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.domain.Dept;
import com.system.service.DeptService;
import com.system.service.UserService;
import com.system.utils.MyPage;
import com.system.utils.controllerUtil.ISearchCondition;

@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController{
	
	private static Logger logger=Logger.getLogger(DeptController.class);

	@Autowired
	private DeptService deptService;
	    
//    @Autowired
//    private SqlSession sqlSession;
   
   
    
    /**
     * @return
     * 分页查询用户数据
     */
    @ResponseBody
    @RequestMapping("/getAllDeptUser")
    public List<Dept> getAllDeptUser() {
    	ISearchCondition searchCodition = getSearchCodition();
    	List<Dept> queryAllDeptUser=null;
    	try {
        	 queryAllDeptUser = deptService.queryAllDeptUser(searchCodition);
		} catch (Exception e) {
			// TODO: handle exception
		}
        return queryAllDeptUser;
    }
    
    
    
}
