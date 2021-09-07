package org.antry.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class AckListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        //获取消息id
        long id = message.getMessageProperties().getDeliveryTag();
        try {
            //获取消息
            System.out.println("AckListener-get-message"+new String(message.getBody()));
            System.out.println("====进行业务处理====");
            //异常
            int i = 5/0;
            /**
             * 确认收到的一条或多条消息。 提供来自AMQP.Basic.GetOk或AMQP.Basic.Deliver方法的 deliveryTag，其中包含正在确认的接收消息。
             * 参数：
             * DeliveryTag – 来自收到的AMQP.Basic.GetOk或AMQP.Basic.Deliver的标签
             * 多个 – true 确认所有消息，包括提供的交付标签； false 仅确认提供的交付标签。
             * 抛出：
             * IOException - 如果遇到错误
             * 也可以看看：
             * AMQP.Basic.Ack
             */
            channel.basicAck(id,true);
        }catch (Exception e){
            /**
             * 拒绝收到的一封或多封邮件。 从包含要拒绝的消息的AMQP.Basic.GetOk或AMQP.Basic.GetOk方法deliveryTag 。
             * 参数：
             * DeliveryTag – 来自收到的AMQP.Basic.GetOk或AMQP.Basic.Deliver的标签
             * 多个 – true 拒绝所有消息，包括提供的交付标签； false 仅拒绝提供的交付标签。
             * requeue – 如果被拒绝的消息应该重新排队而不是丢弃/死信，则为真
             * 抛出：
             * IOException - 如果遇到错误
             * 也可以看看：
             * AMQP.Basic.Nack
             */
            channel.basicNack(id,true,true);
        }
    }
    @Override
    public void onMessage(Message message) {
        throw new IllegalStateException("Should never be called for a ChannelAwareMessageListener");
    }
}
