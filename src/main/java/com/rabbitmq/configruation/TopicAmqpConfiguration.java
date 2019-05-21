package com.rabbitmq.configruation;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.Channel;

/**
 * 消费者配置
 *
 * @author chenhf
 * @create 2017-10-30 下午3:14
 **/
@Configuration
@AutoConfigureAfter(RabbitmqConfig.class)
public class TopicAmqpConfiguration {
	
    @Bean("topicTest1Container")
    public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("TOPICTEST1");
        container.setMessageListener(exampleListener1());
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return container;
    }
 
 
    @Bean("topicTest1Listener")
    public ChannelAwareMessageListener exampleListener1(){
       return new ChannelAwareMessageListener() {

		@Override
		public void onMessage(Message message, Channel channel)
				throws Exception {
			// TODO Auto-generated method stub
			
		}
//            @Override
//            public void onMessage(Message message, Channel channel) throws Exception {
//                TestUser testUser = (TestUser) SerializeUtil.unserialize(message.getBody());
//                System.out.println("TOPICTEST1："+testUser.toString());
//                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
// 
//            }
       };
    }
 

 
}