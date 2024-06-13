package com.liwx.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName PraciteGatewayApplicaiton
 * @Author Liwx
 * @Description
 * @Date 2023/7/6  13:36
 */
@SpringBootApplication(scanBasePackages = {"com.liwx"})
@EnableDiscoveryClient
public class PracticeGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PracticeGatewayApplication.class,args);
    }
}
