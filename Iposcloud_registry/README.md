# Iposcloud_registry
本模块集成了 Eureka和Configserver

|url|desc|  
|:---|:---|  
|http://localhost:8761/registry|Eureka注册中心| 
|http://localhost:8761/config|配置中心|  

## SpringSecurity  
* 引入Maven依赖  

``` maven
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

* 配置 

``` yml
#简单密码认证
security:
    basic:
      enabled: true
    user:
      name: admin
      password: admin
```


## Eureka Server  
* 引入Maven依赖  

``` maven
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka-server</artifactId>
</dependency>
```

* 配置Eureka Server  

``` yml
#hostname需设置/etc/hosts的IP映射
eureka:
    instance:
        hostname: iposcloudregistry
    client:
        service-url:
          defaultZone: http://admin:admin@iposcloudregistry:8761/eureka/
        healthcheck:
          enabled: true
    dashboard:
        path: /registry
```

## Config Server  
* 引入Maven依赖  

``` maven
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

* 配置

``` yml
#configserver
spring:
    cloud:
      config:
        server:
          native:
            searchLocations: classpath:/config
          prefix: /config
        uri: http://127.0.0.1:8761
```



## 启用Eureka Server  ConfigServer

_增加@EnableEurekaServer @EnableConfigServer，启用Eureka Server ConfigServer_  

``` java
@EnableConfigServer
@EnableEurekaServer
@SpringBootApplication //等同于@Configuration　+　@EnableAutoConfiguration和 　+　@ComponentScan
public class RegistryApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistryApplication.class, args);
	}
}
```

## 应用的高可用
### Eureka的高可用
_思路是启动两个对等的EurekaServer，启动的时候将自己注册给自己和另外一个EurekaServer.配置参考：_
``` yml
#iposcloudregistry-peer-2上的配置
eureka:
    instance:
        hostname: iposcloudregistry-peer-2
    client:
        service-url:
          defaultZone: http://admin:admin@iposcloudregistry-peer-1:8761/eureka/,http://admin:admin@iposcloudregistry-peer-2:8761/eureka/
        healthcheck:
          enabled: true
    dashboard:
        path: /registry

#iposcloudregistry-peer-1上的配置
eureka:
    instance:
        hostname: iposcloudregistry-peer-1
    client:
        service-url:
          defaultZone: http://admin:admin@iposcloudregistry-peer-1:8761/eureka/,http://admin:admin@iposcloudregistry-peer-2:8761/eureka/
        healthcheck:
          enabled: true
    dashboard:
        path: /registry
```
### ConfigServer的高可用
_思路更加简单，把它认为是普通的微服务注册到eureka上就行了，如果做了eureka的高可用，那么configserver自动也实现了高可用了。_