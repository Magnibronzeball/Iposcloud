package com.lefu.iposcloudadmin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by think on 2017/4/7.
 */
@EnableAdminServer
@SpringBootApplication
@EnableEurekaClient
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
