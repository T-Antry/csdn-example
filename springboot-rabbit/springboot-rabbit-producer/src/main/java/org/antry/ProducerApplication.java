package org.antry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ProducerApplication.class, args);
        Thread.sleep(100000);
    }
}
