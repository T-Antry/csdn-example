package org.antry.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class FanoutListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println(message.getBody());
    }
}
