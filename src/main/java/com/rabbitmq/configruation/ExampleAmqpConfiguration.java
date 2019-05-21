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



/**
 * 消费者配置
 * 直连消费者
 * 通过设置TestUser的name来测试回调，分别发两条消息，一条UserName为1，一条为2，查看控制台中队列中消息是否被消费
 * @author chenhf
 * @param <Channel>
 * @create 2017-10-30 下午3:14
 **/
@Configuration
@AutoConfigureAfter(RabbitmqConfig.class)
public class ExampleAmqpConfiguration<Channel> {
    @Bean("testQueueContainer")
    public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("TESTQUEUE");
        container.setMessageListener(exampleListener());
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return container;
    }
 
 
    @Bean("testQueueListener")
    public ChannelAwareMessageListener exampleListener() {
        return new ChannelAwareMessageListener() {

			@Override
			public void onMessage(Message message,com.rabbitmq.client.Channel channel) throws Exception {
				// TODO Auto-generated method stub
				
			}
         //   @Override
         //   public void onMessage(Message message, Channel channel) throws Exception {
               // TestUser testUser = (TestUser) SerializeConfig.unserialize(message.getBody());
                //通过设置TestUser的name来测试回调，分别发两条消息，一条UserName为1，一条为2，查看控制台中队列中消息是否被消费
//                if ("2".equals(testUser.getUserName())){
//                    System.out.println(testUser.toString());
//                    channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//                }
// 
//                if ("1".equals(testUser.getUserName())){
//                    System.out.println(testUser.toString());
//                    channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
//                }
 
//            }
        };
    }
 
}