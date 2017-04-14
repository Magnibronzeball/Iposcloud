package com.lefu.iposcloudregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.config.server.EnableConfigServer;
/**
 * 注册中心
 * Created by zhaozhou on 2017/4/6.
 */
@EnableConfigServer
@EnableEurekaServer
@SpringBootApplication //等同于@Configuration　+　@EnableAutoConfiguration和 　+　@ComponentScan
public class RegistryApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistryApplication.class, args);
	}
}
