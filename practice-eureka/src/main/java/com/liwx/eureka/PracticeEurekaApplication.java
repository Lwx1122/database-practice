package com.liwx.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName PracticeEurekaApplication
 * @Author Liwx
 * @Description
 * @Date 2023/7/5$ 16:52
 */
@SpringBootApplication
@EnableEurekaServer
public class PracticeEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PracticeEurekaApplication.class, args);
    }
}
