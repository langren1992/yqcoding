package com.anserx.yqcoding;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.anserx.yqcoding"})
@EnableRabbit
@Slf4j
public class AdminApplication {
    public static void main( String[] args ) {
        SpringApplication.run(AdminApplication.class);
    }
}
