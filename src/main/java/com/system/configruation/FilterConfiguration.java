package com.system.configruation;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.system.filter.MyFilter1;


/**
 * @author ZHANGJUN
 * 添加@Configuration 注解，将自定义Filter加入过滤链
 */
@Configuration
public class FilterConfiguration {
	
	@Bean
    public MyFilter1 fileterMyFilter1() {
        return new MyFilter1();
    }
	
	
	/**
	 * FilterRegistrationBean注册过滤器
	 */
	@Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter1());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
	

}
