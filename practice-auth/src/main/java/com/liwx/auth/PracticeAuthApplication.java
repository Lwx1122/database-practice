package com.liwx.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @ClassName PracticeAuthApplication
 * @Author Liwx
 * @Description
 * @Date 2023/7/6$ 16:07
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.liwx.systemclient.client")
@ComponentScan("com.liwx")
//@EnableAuthorizationServer
public class PracticeAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(PracticeAuthApplication.class, args);
    }

}
