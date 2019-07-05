package com.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqReceiverA {

	    @RabbitListener(queues = "testQueue1")
	    @RabbitHandler
	    public void process1(String message) {
	        System.out.println("RabbitMqReceiverA-testQueue1:,message:" + message);
	    }

	    @RabbitListener(queues = "testQueue2")
	    @RabbitHandler
	    public void process2(String message) {
	        System.out.println("RabbitMqReceiverA-testQueue2:,message:" + message);
	    }
	    
	    
	    @RabbitListener(queues = "testQueue3")
	    @RabbitHandler
	    public void process3(String message) {
	        System.out.println("RabbitMqReceiverA-testQueue3:,message:" + message);
	    }

}