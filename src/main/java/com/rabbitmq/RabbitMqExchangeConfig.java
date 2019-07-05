package com.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
* 用于配置交换机和队列对应关系
* 新增消息队列应该按照如下步骤
* 1、增加queue bean，参见queueXXXX方法
* 2、增加queue和exchange的binding
* @author chenhf
* @create 2017-10-23 上午10:33
**/
@Configuration
@AutoConfigureAfter(RabbitmqConfig.class)
public class RabbitMqExchangeConfig {
	
    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqExchangeConfig.class);


    
    
    //============================定义交换机exchange=====================================================
    /**
     * 主题型交换机 topic
     * @param rabbitAdmin
     * @return
     */
    @Bean
    public TopicExchange contractTopicExchangeDurable(RabbitAdmin rabbitAdmin){
        TopicExchange contractTopicExchange = new TopicExchange("CONTRACT_TOPIC",true,false);
        rabbitAdmin.declareExchange(contractTopicExchange);
        logger.info("完成主题型交换机bean实例化");
        return contractTopicExchange;
    }
    /**
     * 直连型交换机 direct
     * @param rabbitAdmin
     * @return
     */
    @Bean
    public DirectExchange contractDirectExchange(RabbitAdmin rabbitAdmin) {
        DirectExchange contractDirectExchange = new DirectExchange("CONTRACT_DIRECT",true,false);
        rabbitAdmin.declareExchange(contractDirectExchange);
        logger.info("完成直连型交换机bean实例化");
        return contractDirectExchange;
    }   
    /**
     * 订阅交换机 fanout
     * @param rabbitAdmin
     * @return
     */
    @Bean
    public FanoutExchange contractFanoutExchange(RabbitAdmin rabbitAdmin) {
    	FanoutExchange fanoutExchangeExchange = new FanoutExchange("CONTRACT_FANOUT",true,false);
        rabbitAdmin.declareExchange(fanoutExchangeExchange);
        logger.info("完成订阅型交换机bean实例化");
        return fanoutExchangeExchange;
    }
  //=================================================================================================
    
    
    
    
    
   //=====================================================定义队列====================================== 
    /**
     * 定义队列
     */
    @Bean
    Queue queueTest1(RabbitAdmin rabbitAdmin){
        Queue queue = new Queue("testQueue1",true);
        rabbitAdmin.declareQueue(queue);
        logger.info("话题测试队列1实例化完成");
        return queue;
    }
    @Bean
    Queue queueTest2(RabbitAdmin rabbitAdmin){
        Queue queue = new Queue("testQueue2",true);
        rabbitAdmin.declareQueue(queue);
        logger.debug("话题测试队列2实例化完成");
        return queue;
    }
    @Bean
    public Queue queueTest3(RabbitAdmin rabbitAdmin){
        Queue queue = new Queue("testQueue3",true);
        rabbitAdmin.declareQueue(queue);
        logger.info("测试队列3实例化完成");
        return queue;
    }
 
    
    
    
    //============================在此处完成队列和交换机绑定==============================================
    @Bean
    Binding bindingQueueTopicTest1(Queue queueTest1,TopicExchange contractTopicExchangeDurable,RabbitAdmin rabbitAdmin){
        Binding binding = BindingBuilder.bind(queueTest1).to(contractTopicExchangeDurable).with("binding1");
        rabbitAdmin.declareBinding(binding);
        logger.debug("测试队列与话题交换机1绑定:binding=binding1");
        return binding;
    }
    
    @Bean
    Binding bindingQueueTest2(Queue queueTest2,DirectExchange contractDirectExchange,RabbitAdmin rabbitAdmin){
        Binding binding = BindingBuilder.bind(queueTest2).to(contractDirectExchange).with("binding2");
        rabbitAdmin.declareBinding(binding);
        logger.debug("测试队列与直连型交换机2绑定binding=binding2");
        return binding;
    }
    
    @Bean
    public Binding bindingQueueTest3(Queue queueTest3,FanoutExchange contractFanoutExchange,RabbitAdmin rabbitAdmin){
        Binding binding = BindingBuilder.bind(queueTest3).to(contractFanoutExchange);
        rabbitAdmin.declareBinding(binding);
        logger.info("测试队列fanout交换机3绑定:binding=binding3");
        return binding;
    }
}
