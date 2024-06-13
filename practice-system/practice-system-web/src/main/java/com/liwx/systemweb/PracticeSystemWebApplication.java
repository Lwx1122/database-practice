package com.liwx.systemweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.liwx")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.liwx")
public class PracticeSystemWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeSystemWebApplication.class, args);
    }

}
