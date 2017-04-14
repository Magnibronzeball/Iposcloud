package com.lefu.Iposcloud.ServiceDemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by think on 2017/4/10.
 */
@PropertySource("classpath:application.yml")
@PropertySource("classpath:datasouce.properties")
@SpringBootApplication
public class ServiceDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDemoApplication.class, args);
    }
}
