package com.system.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.alibaba.fastjson.JSONArray;
import com.system.utils.controllerUtil.ISearchCondition;
import com.system.utils.controllerUtil.SearchCondition;



/**
 * 控制器基类
 * 
 * @author LUOJL
 * @version 2015-02-25 Controller层命名规范 业务名
 * 			/save 新增 业务名/delete 删除 业务名/update 更新业务名
 * 			/find 查询 业务名/import 导入 业务名/export 导出 业务名/upload 上传（附件）
 *          业务名/download 下载（附件） 业务名/chgstate 包括启用禁用 /userManage 账号管理 
 *          /authorize授权 /attestation 认证 /j_spring_security_logout 登出
 *          /j_spring_security_check 登陆 PS：注意只针对具体业务，加载公用组件操作都不记录，
 *          反例：system/organization/listUnit加载组织树，不记录不可写成：system/organization/listUnit/find
 */
@Controller
@Scope("prototype")
public abstract class BaseController {

	private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);	

	private HttpServletRequest servletRequest;

	private HttpServletResponse servletResponse;

	private HttpSession session;

	@ModelAttribute
	public void setReqOrRes(HttpServletRequest req, HttpServletResponse res) {
		try {
			this.servletRequest = req;
			this.servletResponse = res;
			this.session = req.getSession();
			this.servletRequest.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private static String[] parsePatterns = { "yyyy-MM-dd",
			"yyyy-MM-dd HH24:mm:ss", "yyyy-MM-dd HH24:mm", "yyyy/MM/dd",
			"yyyy/MM/dd HH24:mm:ss", "yyyy/MM/dd HH24:mm" };

	/**
	 * 添加Model消息
	 * 
	 * @param message
	 */
	protected void addMessage(Model model, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages) {
			sb.append(message).append(messages.length > 1 ? "<br/>" : "");
		}
		model.addAttribute("_msg", sb.toString());
	}

	/**
	 * 添加Flash消息
	 * 
	 * @param message
	 */
	/*
	 * protected void addMessage(RedirectAttributes redirectAttributes,
	 * String... messages) { StringBuilder sb = new StringBuilder(); for (String
	 * message : messages) { sb.append(message).append(messages.length > 1 ?
	 * "<br/>" : ""); } redirectAttributes.addFlashAttribute("message",
	 * sb.toString()); }
	 */


	public String arrayToString(String[] ids) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			sb.append("," + ids[i]);
		}
		return sb.toString().replaceFirst(",", "");
	}

	/**
	 * Description:[将request请求对象中的参数封装到ParameterCondition对象中，方便传递和操作<br>
	 * 适用场景：[通过request请求对象传递参数时]<br>
	 * 
	 * @author:luojl
	 * @update: 2015年5月21日
	 * @return IParameterCondition 参数封装接口对象
	 */
	protected synchronized ISearchCondition getSearchCodition() {
		ISearchCondition pc = new SearchCondition(this.servletRequest);
		return pc;
	}

	/**
	 * Description:[将request请求对象中的参数封装到ParameterCondition对象中，方便传递和操作<br>
	 * 适用场景：[通过request请求对象传递参数时(不要登录用户)]<br>
	 * 
	 * @author:lixue
	 * @update: 2017年5月9日
	 * @return IParameterCondition 参数封装接口对象
	 */
	protected synchronized ISearchCondition getSearchCoditions() {
		ISearchCondition pc = new SearchCondition(this.servletRequest);
		return pc;
	}

	

	/**
	 * Description:[设置响应处理结果的消息体，通过添加到map中统一转换成JSON返回给前端]<br>
	 * 
	 * @author:luojl
	 * @update: 2015年5月21日
	 * @param state
	 *            结果状态
	 * @param msg
	 *            消息内容
	 * @return 消息map对象
	 */
	protected Map<String, Object> setResultMessage(Boolean state, String msg) {
		Map<String, Object> resultMsg = new HashMap<String, Object>();
		resultMsg.put("state", state);
		resultMsg.put("msg", msg);
		return resultMsg;
	}

	protected Map<String, Object> setSucceedResultMessage(String msg) {
		Map<String, Object> resultMsg = new HashMap<String, Object>();
		resultMsg.put("state", Boolean.TRUE);
		resultMsg.put("msg", msg);
		return resultMsg;
	}

	protected Map<String, Object> setSucceedResultMessage(String msg,
			Object data) {
		Map<String, Object> resultMsg = new HashMap<String, Object>();
		resultMsg.put("state", Boolean.TRUE);
		resultMsg.put("data", data);
		resultMsg.put("msg", msg);
		return resultMsg;
	}

	protected Map<String, Object> setFailedResultMessage(String msg) {
		Map<String, Object> resultMsg = new HashMap<String, Object>();
		resultMsg.put("state", Boolean.FALSE);
		resultMsg.put("msg", msg);
		return resultMsg;
	}

	/**
	 * Description:[设置响应处理结果的数据信息，通过添加到map中统一转换成JSON返回给前端]<br>
	 * 
	 * @author:luojl
	 * @update: 2015年5月21日
	 * @param total
	 *            数据总数
	 * @param rows
	 *            返回的行数据
	 * @return 结果数据map
	 */
	protected Map<String, Object> setResultData(Long total, Object rows) {
		Map<String, Object> resultMsg = new HashMap<String, Object>();
		resultMsg.put("total", total);
		resultMsg.put("rows", rows);
		return resultMsg;
	}

	/**
	 * Description:[设置响应处理结果的数据信息，通过添加到map中统一转换成JSON返回给前端]<br>
	 * 
	 * @author:luojl
	 * @update: 2015年5月21日
	 * @param total
	 *            数据总数
	 * @param msg
	 *            返回的异常消息
	 * @return 结果数据map
	 */
	protected Map<String, Object> setFailedResultData(String msg) {
		Map<String, Object> resultMsg = new HashMap<String, Object>();
		resultMsg.put("total", 0L);
		resultMsg.put("rows", new JSONArray());
		resultMsg.put("status", Boolean.FALSE);
		resultMsg.put("msg", msg);
		return resultMsg;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public HttpServletResponse getServletResponse() {
		return servletResponse;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}


}
