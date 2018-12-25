package com.system.configruation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.system.interceptor.SessionInterceptor;


/**
 * @author ZHANGJUN
 * 添加@SpringBootConfiguration 注解，将自定义SessionInterceptor加入拦截器中
 */
@SpringBootConfiguration
public class InterceptorConfiguration  extends WebMvcConfigurerAdapter{
	
	@Autowired
	private SessionInterceptor SessionInterceptor;

	
    public void addInterceptors(InterceptorRegistry  registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则        
        // excludePathPatterns 用于排除拦截路径        
    	registry.addInterceptor(SessionInterceptor).addPathPatterns("/**");
    }


}
