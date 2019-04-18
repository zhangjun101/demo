package com.system.configruation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;

/**
 * @author ZHANGJUN
 * 自定义MessageConverters
 * springboot 使用fastjson作为默认json输出
 */
@Configuration
public class FastJsonConfiguration extends WebMvcConfigurerAdapter {
 
	/**
	 * FastJson SerializerFeatures
	 * WriteNullListAsEmpty  ：List字段如果为null,输出为[],而非null
	 * WriteNullStringAsEmpty： 字符类型字段如果为null,输出为"",而非null
	 * DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
	 * WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
	 * WriteMapNullValue：是否输出值为null的字段,默认为false
	 * */
	@Bean
	public FastJsonConfig fastJsonConfig() {
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		SerializerFeature writeMapNullValue = SerializerFeature.WriteMapNullValue;
		SerializerFeature WriteNullStringAsEmpty = SerializerFeature.WriteNullStringAsEmpty;
		SerializerFeature WriteNullNumberAsZero = SerializerFeature.WriteNullNumberAsZero;
		SerializerFeature WriteNullListAsEmpty = SerializerFeature.WriteNullListAsEmpty;
		fastJsonConfig.setSerializerFeatures(writeMapNullValue, WriteNullStringAsEmpty, 
				WriteNullNumberAsZero, WriteNullListAsEmpty);
		return fastJsonConfig;
	}
 
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters(@Qualifier("fastJsonConfig") FastJsonConfig fastJsonConfig) {
		FastJsonHttpMessageConverter4 fastConverter = new FastJsonHttpMessageConverter4();
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}
}