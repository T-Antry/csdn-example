package org.antry.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.antry.utils.RabbitConstant.EXCHANGE_NAME;
import static org.antry.utils.RabbitConstant.QUEUE_NAME;

@Configuration
public class RabbitMqConfig {



    //1、声明交换机
    @Bean("bootExchange")
    public Exchange bootExchange(){

        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }



    //2、声明队列
    @Bean("bootQueue")
    public Queue bootQueue(){

        return QueueBuilder.durable(QUEUE_NAME).build();
    }


    //3、队列与交换机进行绑定
    @Bean
    public Binding bindQueueExchange(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }

}
