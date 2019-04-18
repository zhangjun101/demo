package com.system.configruation;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.system.filter.XSSFilter;


/**
 * @author ZHANGJUN
 * 添加@Configuration 注解，将自定义Filter加入过滤链
 */
@Configuration
public class FilterConfiguration {
	
	@Bean
    public XSSFilter fileterMyFilter1() {
        return new XSSFilter();
    }
	
	
	/**
	 * FilterRegistrationBean注册过滤器
	 */
	@Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new XSSFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("XSSFilter");
        registration.setOrder(1);
        return registration;
    }
	

}
