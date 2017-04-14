package com.lefu.iposcloudgate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关
 * Created by zhaozhou on 2017/4/6.
 */
@EnableZuulProxy
@SpringBootApplication
public class GateApplication {
	public static void main(String[] args) {
		SpringApplication.run(GateApplication.class, args);
	}
}
