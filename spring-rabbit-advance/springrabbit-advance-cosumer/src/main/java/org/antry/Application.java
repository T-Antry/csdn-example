package org.antry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:spring-consumer.xml");
    }
}
