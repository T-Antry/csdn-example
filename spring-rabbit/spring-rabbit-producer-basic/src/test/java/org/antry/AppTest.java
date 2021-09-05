package org.antry;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producer.xml")
public class AppTest 
{

    //1.注入 RabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void testHelloWorld(){
        //2.发送消息

        rabbitTemplate.convertAndSend("spring_queue","hello world spring....");
    }


    /**
     * 发送fanout消息
     */
    @Test
    public void testFanout(){
        //2.发送消息

        rabbitTemplate.convertAndSend("spring_fanout_exchange","","spring fanout....");
    }


    @Test
    public void testDirect(){
        //2.发送消息

        rabbitTemplate.convertAndSend("spring_direct_exchange","info","spring Direct....");
    }

    /**
     * 发送topic消息
     */
    @Test
    public void testTopics(){
        //2.发送消息

        rabbitTemplate.convertAndSend("spring_topic_exchange","antry.hehe.haha","spring topic....");
    }
}
