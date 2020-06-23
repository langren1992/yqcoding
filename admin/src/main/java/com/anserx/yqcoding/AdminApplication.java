package com.anserx.yqcoding;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.anserx.yqcoding"})
@MapperScan("com.anserx.yqcoding.**.mapper")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableRabbit
@Slf4j
public class AdminApplication {
    public static void main( String[] args ) {
        SpringApplication.run(AdminApplication.class);
    }
}
