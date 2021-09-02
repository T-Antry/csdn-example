package org.antry.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.antry.utils.RabbitConstant;
import org.antry.utils.RabbitUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;


public class WeatherBurean {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitUtils.getConnection();
        String input = new Scanner(System.in).next();
        Channel channel = connection.createChannel();
        //第一个参数交换机名字   其他参数和之前的一样
        channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER,"" , null , input.getBytes());

        channel.close();
        connection.close();
    }


}
