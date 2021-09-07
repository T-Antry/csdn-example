package org.antry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-producer.xml")
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testConfirm() throws InterruptedException {

        //定义回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             * 确认回调。
             * 参数：
             * @param correlationData 相关数据 – 回调的相关数据。
             * @param ack ack 为真，nack 为假
             * @param cause 可选原因，如果可用，则为 nack，否则为 null。
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                System.out.println("=======Confirm方法被执行了======");
                if(ack){
                    System.out.println("消息接收正常："+cause);
                }else{
                    System.out.println("消息接收失败："+cause);
                }
            }
        });

        //进行消息发送
        rabbitTemplate.convertAndSend("test_exchange_confirm_111","confirm","message Confirm...");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRuturn(){
        //设置交换机处理失败消息的模式   为true的时候，消息达到不了队列时，会将消息重新返回给生产者
        rabbitTemplate.setMandatory(true);
        //定义回调
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /**
             * 参数：
             * @param message 返回的消息
             * @param replyCode 回复代码
             * @param replyText 回复文本
             * @param exchange 交换
             * @param routingKey 路由密钥
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("return执行了！");
                System.out.println("message:"+message);
                System.out.println("replyCode:"+replyCode);
                System.out.println("replyText:"+replyText);
                System.out.println("exchange:"+exchange);
                System.out.println("routingKey:"+routingKey);
            }
        });

        //进行消息发送
        rabbitTemplate.convertAndSend("test_exchange_confirm","confirm1","message return...");

        //进行睡眠操作
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //批量发送消息，让消费者每次拉去指定的数量
    @Test
    public void  testQos(){

        for (int i = 0; i < 10; i++) {
            // 发送消息
            rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm", "message confirm....");
        }

    }

    @Test
    public void  testTTl(){


            rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.ad", "test_exchange_ttl test_exchange_ttl....");


    }

    @Test
    public void  testDDL(){

        for (int i = 0; i < 21; i++) {
            rabbitTemplate.convertAndSend("test_exchange_dlx", "test.dlx.ad", "test_exchange_ttl test_exchange_ttl....");
        }



    }
}
