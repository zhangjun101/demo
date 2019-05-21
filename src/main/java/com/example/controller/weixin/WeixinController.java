//package com.v2.swcares.controller.weixin;
//
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.luojl.core.exception.BusinessException;
//import com.util.StringUtils;
//import com.v2.swcares.core.Constants;
//import com.v2.swcares.core.utils.HttpSendUrl;
//import com.v2.swcares.service.weixin.WeixinApp;
//
///**
// * Created on 2018年7月20日<br>
// * Title:       [3UPSI]_[线下领取]<br>
// * Description: [微信JS-SDK服务器端功能]<br>
// * Copyright:   Copyright (c) 2018<br>
// * Company:     民航西南凯亚<br>
// * Department:  研发部<br>
// * @author         hanliang
// * @version        1.0
//*/
//@Controller
//@RequestMapping("/weixin")
//public class WeixinController {
//	
//	Logger logger = Logger.getLogger(WeixinController.class);
//
//    private WeixinApp weixinApp;
//
//    @Autowired
//    public WeixinController(WeixinApp weixinApp) {
//        this.weixinApp = weixinApp;
//    }
//    
//    /**
//     * 重定向获取code的链接
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/getWeChartCode")
//    @ResponseBody
//    public String getWeChartCode() throws Exception {
//    	return Constants.GET_WECHART_CODE_URL;
//    }
//    
//    /**
//     * 微信回调获取code和state
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/callback")
//    @ResponseBody
//    public String weChartCallback(String code, String state, HttpServletRequest request) throws Exception {
//    	logger.info("微信回调获参数【code："+code+" , state: " + state);
//    	
//    	if(StringUtils.isEmptyStr(code) || StringUtils.isEmptyStr(state)){
//    		throw new BusinessException("login error, code is null");
//    	}
//    	
//    	//签名验证
//    	if(!state.equals(Constants.WECHART_STATE)){
//    		throw new BusinessException("state is error, please check state!");
//    	}
//    	
//    	//获取openId
//        String openIdInfos = HttpSendUrl.httpURLConectionGET(String.format(Constants.GET_OPENID, code));
//        request.getSession().setAttribute(Constants.OPENID_INFOS, openIdInfos);
//        return openIdInfos;
//    }
//    
//    /**
//     * 提供openId相关的接口
//     * @param request
//     * @return
//     */
//    @RequestMapping("/queryOpenId")
//    @ResponseBody
//    public String queryOpenId(HttpServletRequest request){
//		return (String) request.getSession().getAttribute(Constants.OPENID_INFOS);
//    }
//    
//    /**
//     * 
//     * 验证和微信的连接 <br/>      
//     *  
//     * @param signature 
//     *        微信签名
//     * @param timestamp 
//     *        签名时的时间
//     * @param nonce 
//     *        随机字符串
//     * @param echostr 
//     *        返回给微信的信息
//     * @throws Exception 
//     *         可能抛出的操作异常  
//     */
//    @RequestMapping("/verify")
//    public @ResponseBody String verifyWeixinConnection(@RequestParam String signature, @RequestParam String timestamp, @RequestParam String nonce,
//            @RequestParam String echostr, HttpServletResponse response) throws Exception {
//        boolean flag = weixinApp.verifyConnection(signature, timestamp, nonce);
//        if (flag) {
//            return echostr;
//        }
//        return null;
//    }
//
//    /**
//     * 
//     * 获取微信JS-SDK签名数据 <br/>      
//     *  
//     * @throws Exception 
//     *         可能抛出的操作异常  
//     */
//    @RequestMapping("/signature")
//    public @ResponseBody String signatureJSSDK() throws Exception {
//        String noncestr = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
//        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
//        String sign = weixinApp.generateSign(noncestr, timestamp);
//        String jsonStr = "{\"appId\":\"wx2d6bc07b73214418\",\"noncestr\":\"" + noncestr + "\",\"timestamp\":\"" + timestamp + "\",\"sign\":\"" + sign
//                + "\"}";
//        return jsonStr;
//    }
//
//    /**
//     * 
//     * 航延线上领取 <br/>      
//     *  
//     */
//    @RequestMapping("/displayPage")
//    public String displayPage() {
//        return "index";
//    }
//
//    /**
//     * 
//     * 事后领取界面 <br/>      
//     *  
//     */
//    @RequestMapping("/afterQueryPage")
//    public String afterQueryPage() {
//        return "index1";
//    }
//    
//    
//    /**
//     * 异常处理 <br/>      
//     * @param ex 
//     * 捕获的异常
//     */
//    @ExceptionHandler
//    public @ResponseBody String handle(Exception ex) {
//    	ex.printStackTrace();
//    	logger.error(ex);
//        return ex.getMessage();
//    }
//    
//    
//}
