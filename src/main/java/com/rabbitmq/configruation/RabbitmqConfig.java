package com.rabbitmq.configruation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.rabbitmq.client.ConnectionFactory;




/**
 * @author ZHANGJUN
 * 定义rabbit配置
 */
@Configuration
public class RabbitmqConfig {
	
    private static final Logger log= LoggerFactory.getLogger(RabbitmqConfig.class);
    
   // @Autowired
    //private static Environment env;

    /** 
     * 创建链接
     * @return CachingConnectionFactory
     */
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("127.0.0.1",5672);
        connectionFactory.setUsername("zhangjun");
        connectionFactory.setPassword("101908");
        connectionFactory.setVirtualHost("test");
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    /** 
     * RabbitAdmin封装了对 RabbitMQ 的管理操作
     * @return RabbitAdmin
     */
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory());
    }
    
    /** 
     * 必须是prototype类型
     * @return RabbitTemplate
     */
    @Bean
    @Scope("prototype")
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }


}

