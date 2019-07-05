package com.rabbitmq;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZHANGJUN
 *
 */
@Component
public class RabbitMqSender implements RabbitTemplate.ConfirmCallback{

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqSender.class);
    
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    public RabbitMqSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
    
    }
 
    /**
     * 发送到 指定routekey的指定交换机
     * @param routeKey
     * @param obj
     */
    public void sendRabbitmq(String change,String rootkey,String message) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        this.rabbitTemplate.convertAndSend(change,rootkey, message);
    }
 

    
    
}
