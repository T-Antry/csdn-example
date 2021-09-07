package org.antry.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class QosListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        //获取到的消息
        System.out.println("2-get-message"+new String(message.getBody()));
        Thread.sleep(1000);
        //签收
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }
    @Override
    public void onMessage(Message message) {
        throw new IllegalStateException("Should never be called for a ChannelAwareMessageListener");
    }
}
